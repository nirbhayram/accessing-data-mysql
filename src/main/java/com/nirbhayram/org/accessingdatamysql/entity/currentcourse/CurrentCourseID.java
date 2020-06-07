package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CurrentCourseID implements Serializable {

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Medicine medicine;

    public CurrentCourseID() {

    }


    public CurrentCourseID(User user, Medicine medicine) {
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
        return Objects.hash(this.getUser().getUserId(),this.getMedicine().getMedicineId());
    }

    @Override
    public boolean equals(Object o) {
        if (this==o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCourseID currentCourseId = (CurrentCourseID)o;
        return currentCourseId.getUser().getUserId()==this.getUser().getUserId() &&
                currentCourseId.getMedicine().getMedicineId()==this.getMedicine().getMedicineId();
    }
}
