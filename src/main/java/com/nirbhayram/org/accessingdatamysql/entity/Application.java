package com.nirbhayram.org.accessingdatamysql.entity;

import javax.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "app_id")
    private int id;

    @Column(name = "app_name")
    private String name;

    @Column(length = 200)
    private String discription;

    private String owner;

    public Application() {
    }

    public Application(String name, String discription, String owner) {
        this.name = name;
        this.discription = discription;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
