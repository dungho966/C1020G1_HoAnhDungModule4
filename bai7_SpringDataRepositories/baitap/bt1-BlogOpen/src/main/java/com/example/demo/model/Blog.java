package com.example.demo.model;


import javax.persistence.*;

@Entity
        @Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id ;
    private String tittle ;
    private String content ;

    @ManyToOne
    @JoinColumn
    private Category category ;

    public Category getCategory(){
        return category ;
    }

    public void setCategory(Category category){
        this.category = category ;
    }

    public Blog() {
    }

    @Override
    public String toString() {
        return String.format("Blog[id=%d, tittle='%s', content='%s']", id, tittle, content);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
