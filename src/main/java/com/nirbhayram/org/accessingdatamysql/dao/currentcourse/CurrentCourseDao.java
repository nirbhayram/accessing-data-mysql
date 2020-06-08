package com.nirbhayram.org.accessingdatamysql.dao.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentcourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class CurrentCourseDao implements ICurrentCourseDao {

    @Autowired
    private CurrentcourseRepository currentcourseRepository;

    @Override
    public void addCurrentCourse(CurrentCourse currentCourse) {
        currentcourseRepository.save(currentCourse);
    }

    @Override
    public void updateCurrentCourse(CurrentCourse currentCourse) {
        currentcourseRepository.save(currentCourse);
    }

    @Override
    public CurrentCourse getCurrentCourseById(CurrentCourseID currentCourseID) {
        Optional<CurrentCourse> optionalCurrentCourse = currentcourseRepository.findById(currentCourseID);
        if (optionalCurrentCourse.isEmpty()) {
            return null;
        }
        return optionalCurrentCourse.get();
    }

    @Override
    public void deleteCurrentCourse(CurrentCourse currentCourse) {
        currentcourseRepository.delete(currentCourse);
    }

    @Override
    public List<CurrentCourse> getAllCurrentCourse() {
        Iterable<CurrentCourse> currentCourseIterable = currentcourseRepository.findAll();
        Iterator<CurrentCourse> currentCourseIterator = currentCourseIterable.iterator();
        List<CurrentCourse> list = new ArrayList<CurrentCourse>();
        while (currentCourseIterator.hasNext()) {
            list.add(currentCourseIterator.next());
        }
        return list;
    }

    @Override
    public List<CurrentCourse> getAllCurrentCourseOfUser(int userId) {
        return currentcourseRepository.findByCurrentCourseIDUserUserId(userId);
    }

    @Override
    public List<CurrentCourse> getAllCurrentCourseOfMedicine(int medicineId) {
        return currentcourseRepository.findByCurrentCourseIDMedicineMedicineId(medicineId);
    }

    @Override
    public CurrentCourse getCurrentCourseOfUserAndMedicine(int userId, int medicineId) {
        return currentcourseRepository.findByCurrentCourseIDUserUserIdAndCurrentCourseIDMedicineMedicineId(userId, medicineId);
    }
}
