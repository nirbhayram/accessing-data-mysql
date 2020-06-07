package com.nirbhayram.org.accessingdatamysql.requestmapping;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CurrentCourseRequest {

    private int userId;

    private int medicineId;

    private int dailyConsuption;

    private int remainingTablets;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startedDate;

    public CurrentCourseRequest(int userId, int medicineId, int dailyConsuption, int remainingTablets, Date startedDate) {
        this.userId = userId;
        this.medicineId = medicineId;
        this.dailyConsuption = dailyConsuption;
        this.remainingTablets = remainingTablets;
        this.startedDate = startedDate;
    }

    public CurrentCourseRequest() {
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
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


}
