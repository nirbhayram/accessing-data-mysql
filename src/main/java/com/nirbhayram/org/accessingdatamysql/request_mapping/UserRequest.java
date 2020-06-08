package com.nirbhayram.org.accessingdatamysql.request_mapping;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserRequest {

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String mobile;

    private String place;

    public UserRequest(String name, Date dateOfBirth, String mobile, String place) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.mobile = mobile;
        this.place = place;
    }

    public UserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
