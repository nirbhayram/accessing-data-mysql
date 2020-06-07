package com.nirbhayram.org.accessingdatamysql.dao.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import java.util.List;

public interface ICurrentCourseDao {

    void addCurrentCourse(CurrentCourse currentCourse);

    void updateCurrentCourse(CurrentCourse currentCourse);

    CurrentCourse getCurrentCourseById(CurrentCourseID currentCourseID);

    void deleteCurrentCourse(CurrentCourse currentCourse);

    List<CurrentCourse> getAllCurrentCourse();

    List<CurrentCourse> getAllCurrentCourseOfUser(int userId);

    List<CurrentCourse> getAllCurrentCourseOfMedicine(int medicineId);

    CurrentCourse getCurrentCourseOfUserAndMedicine(int userId, int medicineId);

}
