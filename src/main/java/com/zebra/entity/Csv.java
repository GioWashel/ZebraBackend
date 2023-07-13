package com.zebra.entity;


import jakarta.persistence.*;

@Entity
public class Csv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private int userID;

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getUserID() {
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
