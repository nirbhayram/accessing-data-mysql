package com.nirbhayram.org.accessingdatamysql.dao.previouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourse;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import java.util.List;

public interface IPreviousCourseDao {
    void addPreviousCourse(PreviousCourse previousCourse);

    List<PreviousCourse> getAllPreviousCourse();

    List<PreviousCourse> getPreviousCourseOfUser(User user);

    List<PreviousCourse> getPreviousCourseOfMedicine(Medicine medicine);

    List<PreviousCourse> getPreviousCourseOfUserId(int userId);

    List<PreviousCourse> getPreviousCourseOfMedicineId(int medicineId);

    List<PreviousCourse> getPreviousCourseOfUserIdAndMedicineId(int userId, int medicineId);
}
