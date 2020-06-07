package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CurrentCourse implements Serializable {

    @EmbeddedId
    private CurrentCourseID currentCourseID;

    private int dailyConsuption;

    private int remainingTablets;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startedDate;

    public CurrentCourseID getCurrentCourseID() {
        return currentCourseID;
    }

    public void setCurrentCourseID(CurrentCourseID currentCourseID) {
        this.currentCourseID = currentCourseID;
    }

    public CurrentCourse() {
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
