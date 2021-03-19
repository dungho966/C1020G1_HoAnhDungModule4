package com.example.demo.service.impl;

import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.model.User user = this.userRepository.findByUserName(username);

        //Nếu khong tìm thấy User thì mình thông báo lỗi
        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }


        // Khi đã có user rồi thì mình query xem user đó có những quyền gì (Admin hay User)
        // [ROLE_USER, ROLE_ADMIN,..]

        List<UserRole> userRoles = userRoleRepository.findByUser(user);
        // Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority  của spring cho quyền đó
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getRoleName());
                grantList.add(authority);
            }
        }

        //Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp cá thông số như tên , password và quyền
        // Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp Spring Security quản lý được phân quyền như ta đã
        // cấu hình trong bước 4 method configure
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), grantList);

        return userDetails;
    }
}

