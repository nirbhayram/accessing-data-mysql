package com.nirbhayram.org.accessingdatamysql.entity.currentcourse;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrentcourseRepository extends CrudRepository<CurrentCourse, CurrentCourseID> {
    CurrentCourse findByCurrentCourseIDUserUserIdAndCurrentCourseIDMedicineMedicineId(int userId, int medicineId);
    List<CurrentCourse> findByCurrentCourseIDUserUserId(int uesrId);
    List<CurrentCourse> findByCurrentCourseIDMedicineMedicineId(int medicibeId);
}

