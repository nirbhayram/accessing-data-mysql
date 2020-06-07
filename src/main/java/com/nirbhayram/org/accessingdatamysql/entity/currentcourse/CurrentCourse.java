package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(CurrentCourseID.class)
public class CurrentCourse implements Serializable {

    @Id
    private CurrentCourseID currentCourseID;

    private int dailyConsuption;

    private int remainingTablets;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startedDate;


    public CurrentCourse() {
    }

    public CurrentCourse(CurrentCourseID currentCourseID, int dailyConsuption, int remainingTablets, Date startedDate) {
        this.currentCourseID = currentCourseID;
        this.dailyConsuption = dailyConsuption;
        this.remainingTablets = remainingTablets;
        this.startedDate = startedDate;
    }

    public CurrentCourseID getCurrentCourseID() {
        return currentCourseID;
    }

    public void setCurrentCourseID(CurrentCourseID currentCourseID) {
        this.currentCourseID = currentCourseID;
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
