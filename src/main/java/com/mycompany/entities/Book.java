package com.mycompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int stock;
    private String section;

    public Book(){}

    public Book(String name, int stock, String section){
        this.name = name;
        this.stock = stock;
        this.section = section;
    }

    public Book(int stock, String section){
        this.name = "UNKNOWN";
        this.stock = stock;
        this.section = section;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String getSection(){
        return section;
    }

    public void setSection(String section){
        this.section = section;
    }
}
