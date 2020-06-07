package com.nirbhayram.org.accessingdatamysql.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@JsonFormat
public class CurrentCourseRequest {

    private int userid;

    private int medicineid;

    private int dailyConsuption;

    private int remainingTablets;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startedDate;

    public CurrentCourseRequest() {
    }

    public CurrentCourseRequest(int userid, int medicineid, int dailyConsuption, int remainingTablets, Date startedDate) {
        this.userid = userid;
        this.medicineid = medicineid;
        this.dailyConsuption = dailyConsuption;
        this.remainingTablets = remainingTablets;
        this.startedDate = startedDate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(int medicineid) {
        this.medicineid = medicineid;
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
