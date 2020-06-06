package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(CurrentCourseID.class)
public class CurrentCourse implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "userid")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "medicine_id" ,referencedColumnName = "medicine_id")
    private Medicine medicine;

    private int dailyConsuption;

    private int remainingTablets;

    private Date startedDate;

    public CurrentCourse(User user, Medicine medicine, int dailyConsuption, int remainingTablets, Date startedDate) {
        this.user = user;
        this.medicine = medicine;
        this.dailyConsuption = dailyConsuption;
        this.remainingTablets = remainingTablets;
        this.startedDate = startedDate;
    }

    public CurrentCourse() {
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

    public int getDailyConsuption() {
        return dailyConsuption;
    }

    public void setDailyConsuption(int dailyConsuption) {
        this.dailyConsuption = dailyConsuption;
    }

    public int getRemainingTablets() {
        return remainingTablets;
    }

    public void setRemainingTablets(int remainingTablets) {
        this.remainingTablets = remainingTablets;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }
}
