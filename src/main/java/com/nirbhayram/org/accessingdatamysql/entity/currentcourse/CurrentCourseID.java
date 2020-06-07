package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;


public class CurrentCourseID implements Serializable {

    @ManyToOne
    @JoinColumn(referencedColumnName = "userid")
    private int userId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "medicine_id")
    private int medicineId;

    public CurrentCourseID() {
    }

    public CurrentCourseID(Integer userId, Integer medicineId) {
        this.userId = userId;
        this.medicineId = medicineId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId,medicineId);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCourseID currentCourseId = (CurrentCourseID)o;
        return (currentCourseId.getUserId()==this.getUserId() &&
                currentCourseId.getMedicineId()==this.getMedicineId());
    }
}
