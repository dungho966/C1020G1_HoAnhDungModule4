package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false)
    private long id ;

    @ManyToOne
    @JoinColumn(name = "User_Id" , nullable = false)
    private AppRole appUser ;

    @ManyToOne
    @JoinColumn(name = "Role_Id" , nullable = false)
    private AppRole appRole ;

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppRole getAppUser() {
        return appUser;
    }

    public void setAppUser(AppRole appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
