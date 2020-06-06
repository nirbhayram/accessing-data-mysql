package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(PreviousCourseID.class)
public class PreviousCourse implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "userid")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "medicine_id" ,referencedColumnName = "medicine_id")
    private Medicine medicine;

    private Date dateOfCompletion;

    public PreviousCourse(User user, Medicine medicine, Date dateOfCompletion) {
        this.user = user;
        this.medicine = medicine;
        this.dateOfCompletion = dateOfCompletion;
    }

    public PreviousCourse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

}
