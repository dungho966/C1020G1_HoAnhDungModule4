package com.example.demo.repository;

import com.example.demo.model.AppRole;
import com.example.demo.model.AppUser;
import com.example.demo.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole , Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser) ;
}
