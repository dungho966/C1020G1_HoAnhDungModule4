package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "User_Id" , nullable = false)
    private long userId ;


    @Column(name = "User_name" , length = 36 , nullable = false)
    private String userName ;


    @Column(name = "Encryted_Password" , length = 128 , nullable = false)
    private String encrytedPassword ;


    @Column(name = "Enable" , nullable = false ,length = 1)
    private boolean enable ;

    public AppUser() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
