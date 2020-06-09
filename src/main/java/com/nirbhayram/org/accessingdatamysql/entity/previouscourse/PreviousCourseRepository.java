package com.nirbhayram.org.accessingdatamysql.entity.previouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreviousCourseRepository extends CrudRepository<PreviousCourse, PreviousCourseID> {
    List<PreviousCourse> findByPreviousCourseIDUserUserIdAndPreviousCourseIDMedicineMedicineId(int userId, int medicineId);

    List<PreviousCourse> findByPreviousCourseIDUserUserId(int userId);

    List<PreviousCourse> findByPreviousCourseIDUser(User user);

    List<PreviousCourse> findByPreviousCourseIDMedicineMedicineId(int medicineId);

    List<PreviousCourse> findByPreviousCourseIDMedicine(Medicine medicine);
}
