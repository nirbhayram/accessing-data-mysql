//package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;
//
//import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
//import com.nirbhayram.org.accessingdatamysql.entity.user.User;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class PreviousCourseID implements Serializable {
//
//    private User user;
//
//    private Medicine medicine;
//
//    public PreviousCourseID(User user, Medicine medicine) {
//        this.user = user;
//        this.medicine = medicine;
//    }
//
//    public PreviousCourseID() {
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(user.getId(),medicine.getId());
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this==o)
//            return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PreviousCourseID previousCourseId = (PreviousCourseID) o;
//        return previousCourseId.user.getId()==this.user.getId() &&
//                previousCourseId.medicine.getId()==this.medicine.getId();
//    }
//}
