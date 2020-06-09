package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PreviousCourseID implements Serializable {

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Medicine medicine;

    public PreviousCourseID() {
    }

    public PreviousCourseID(User user, Medicine medicine) {
        this.user = user;
        this.medicine = medicine;
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

    @Override
    public int hashCode() {
        return Objects.hash(user.getUserId(), medicine.getMedicineId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreviousCourseID previousCourseId = (PreviousCourseID) o;
        return previousCourseId.user.getUserId() == this.user.getUserId() &&
                previousCourseId.medicine.getMedicineId() == this.medicine.getMedicineId();
    }
}
