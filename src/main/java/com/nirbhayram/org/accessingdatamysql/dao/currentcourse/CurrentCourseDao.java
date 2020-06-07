package com.nirbhayram.org.accessingdatamysql.dao.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentcourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CurrentCourseDao implements ICurrentCourseDao {

    @Autowired
    private CurrentcourseRepository currentcourseRepository;

    @Override
    public boolean addCurrentCourse(CurrentCourse currentCourse) {
        if (null != checkIfCurrentCourseExists(currentCourse.getCurrentCourseID().getUserId(), currentCourse.getCurrentCourseID().getMedicineId())) {
            currentcourseRepository.save(currentCourse);
            return true;
        }
        return false;
    }

    @Override
    public CurrentCourse checkIfCurrentCourseExists(int userId, int medicineId) {
        Optional<CurrentCourse> optionalCurrentCourse = currentcourseRepository.findById(new CurrentCourseID(userId, medicineId));
        if (optionalCurrentCourse.isEmpty()) {
            return null;
        }
        return optionalCurrentCourse.get();
    }

    @Override
    public boolean updateCurrentCourse(CurrentCourse currentCourse) {
        Optional<CurrentCourse> optionalCurrentCourse = currentcourseRepository.findById(new CurrentCourseID(currentCourse.getCurrentCourseID().getUserId(), currentCourse.getCurrentCourseID().getMedicineId()));
        if (optionalCurrentCourse.isEmpty()) {
            return false;
        }
        CurrentCourse currentCourse1 = optionalCurrentCourse.get();
//        currentCourse1.getCurrentCourseID().setUserId(currentCourse.getCurrentCourseID().getUserId());
//        currentCourse1.getCurrentCourseID().setMedicineId(currentCourse.getCurrentCourseID().getMedicineId());
        currentCourse1.setDailyConsuption(currentCourse.getDailyConsuption());
        currentCourse1.setRemainingTablets(currentCourse.getRemainingTablets());
        currentcourseRepository.save(currentCourse1);
        return true;
    }

    @Override
    public boolean deleteCurrentCourse(CurrentCourse currentCourse) {
//        Optional<CurrentCourse> optionalCurrentCourse = currentcourseRepository.findById(new CurrentCourseID(currentCourse.getUserId(), currentCourse.getMedicineId()));
//        if (optionalCurrentCourse.isEmpty()) {
//            return false;
//        }
//        currentcourseRepository.delete(optionalCurrentCourse.get());
//        return true;
        return false;
    }
}
