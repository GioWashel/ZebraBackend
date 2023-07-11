package com.zebra.entity;


import jakarta.persistence.*;

@Entity
@Table(name= "csv")
public class Csv {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public Long getUserID() {
        return this.userID;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Id
    public Long getId() {
        return id;
    }
}