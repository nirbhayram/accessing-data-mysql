package com.nirbhayram.org.accessingdatamysql.entity.medicine;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @Column(name = "medicine_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 20,name = "medicine_name",unique = true,nullable = false)
    private String medicineName;

    @Column(length = 200)
    private String discription;

    //TODO storing image into relational database;

    @Column(length = 20)
    private String reason;

    public Medicine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Medicine(String medicineName, String discription, String reason) {
        this.medicineName = medicineName;
        this.discription = discription;
        this.reason = reason;
    }
}
