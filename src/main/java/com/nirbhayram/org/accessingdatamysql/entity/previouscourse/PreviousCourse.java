package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PreviousCourse implements Serializable {

    @EmbeddedId
    private PreviousCourseID previousCourseID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfCompletion;

    public PreviousCourse(PreviousCourseID previousCourseID, Date dateOfCompletion) {
        this.previousCourseID = previousCourseID;
        this.dateOfCompletion = dateOfCompletion;
    }

    public PreviousCourse() {
    }

    public PreviousCourseID getPreviousCourseID() {
        return previousCourseID;
    }

    public void setPreviousCourseID(PreviousCourseID previousCourseID) {
        this.previousCourseID = previousCourseID;
    }

    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

}
