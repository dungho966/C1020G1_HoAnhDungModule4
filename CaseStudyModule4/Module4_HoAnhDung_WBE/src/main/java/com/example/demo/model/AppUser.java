package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {
    @Id
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Password", length = 128, nullable = false)
    private String password;


//    @OneToOne(targetEntity = Employee.class,mappedBy = "appUser")
//    public Employee employee ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }





}
