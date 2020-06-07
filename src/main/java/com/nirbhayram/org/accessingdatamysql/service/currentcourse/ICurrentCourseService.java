package com.nirbhayram.org.accessingdatamysql.service.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;

public interface ICurrentCourseService {
    boolean addCurrentCourse(CurrentCourse currentCourse);

    CurrentCourse checkIfCurrentCourseExists(int userId, int medicineId);

    boolean updateCurrentCourse(CurrentCourse currentCourse);

    boolean deleteCurrentCourse(CurrentCourse currentCourse);
}
