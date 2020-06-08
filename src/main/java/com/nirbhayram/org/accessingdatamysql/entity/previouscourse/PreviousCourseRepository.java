package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreviousCourseRepository extends CrudRepository<PreviousCourse, PreviousCourseID> {
    PreviousCourse findByPreviousCourseIDUserUserIdAndPreviousCourseIDMedicineMedicineId(int userId, int medicineId);

    List<PreviousCourse> findByPreviousCourseIDUserUserId(int userId);
}
