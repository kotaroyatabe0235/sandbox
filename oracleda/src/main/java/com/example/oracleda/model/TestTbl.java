package com.example.oracleda.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class TestTbl {

    public TestTbl(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestTbl(int id) {
        this.id = id;
    }
    

    @Id
    public int id;
    public String name;    
}
