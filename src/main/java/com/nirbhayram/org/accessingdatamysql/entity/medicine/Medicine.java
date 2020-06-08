package com.nirbhayram.org.accessingdatamysql.entity.medicine;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medicineId;

    @Column(length = 100,name = "medicine_name",unique = true,nullable = false)
    private String medicineName;

    private String discription;

    //TODO storing image into relational database;

    private String reason;

    public Medicine() {
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
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

    public Medicine(Integer medicineId, String medicineName, String discription, String reason) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.discription = discription;
        this.reason = reason;
    }
}
