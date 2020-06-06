package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import java.io.Serializable;
import java.util.Objects;

public class CurrentCourseID implements Serializable {

    private User user;

    private Medicine medicine;

    public CurrentCourseID() {

    }

    public CurrentCourseID(User user, Medicine medicine) {
        this.user = user;
        this.medicine = medicine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(),medicine.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this==o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCourseID currentCourseId = (CurrentCourseID)o;
        return currentCourseId.user.getId()==this.user.getId() &&
                currentCourseId.medicine.getId()==this.medicine.getId();
    }
}
