package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
        @Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    private String name ;

    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs ;

    public Category(String name){
        this.name = name ;
    }
    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlogs(List<Blog> blogs){
        this.blogs = blogs ;
    }

    @Override
    public String toString() {
        return name;
    }
}
