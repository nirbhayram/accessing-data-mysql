package com.nirbhayram.org.accessingdatamysql.dao.previouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourse;
import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourseRepository;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PreviousCourseDao implements IPreviousCourseDao {

    @Autowired
    PreviousCourseRepository previousCourseRepository;

    @Override
    public void addPreviousCourse(PreviousCourse previousCourse) {
        previousCourseRepository.save(previousCourse);
    }

    @Override
    public List<PreviousCourse> getAllPreviousCourse() {
        Iterable<PreviousCourse> iterable = previousCourseRepository.findAll();
        Iterator<PreviousCourse> iterator = iterable.iterator();
        List<PreviousCourse> list = new ArrayList<PreviousCourse>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @Override
    public List<PreviousCourse> getPreviousCourseOfUser(User user) {
        return previousCourseRepository.findByPreviousCourseIDUser(user);
    }

    @Override
    public List<PreviousCourse> getPreviousCourseOfMedicine(Medicine medicine) {
        return previousCourseRepository.findByPreviousCourseIDMedicine(medicine);
    }

    @Override
    public List<PreviousCourse> getPreviousCourseOfUserId(int userId) {
        return previousCourseRepository.findByPreviousCourseIDUserUserId(userId);
    }

    @Override
    public List<PreviousCourse> getPreviousCourseOfMedicineId(int medicineId) {
        return previousCourseRepository.findByPreviousCourseIDMedicineMedicineId(medicineId);
    }

    @Override
    public List<PreviousCourse> getPreviousCourseOfUserIdAndMedicineId(int userId, int medicineId) {
        return previousCourseRepository.findByPreviousCourseIDUserUserIdAndPreviousCourseIDMedicineMedicineId(userId, medicineId);
    }
}
