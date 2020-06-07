package com.nirbhayram.org.accessingdatamysql.service.currentcourse;

import com.nirbhayram.org.accessingdatamysql.dao.currentcourse.ICurrentCourseDao;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentCourseService implements ICurrentCourseService {

    @Autowired
    private ICurrentCourseDao currentCourseDao;

    @Override
    public boolean addCurrentCourse(CurrentCourse currentCourse) {
        return currentCourseDao.addCurrentCourse(currentCourse);
    }

    @Override
    public CurrentCourse checkIfCurrentCourseExists(int userId, int medicineId) {
        return currentCourseDao.checkIfCurrentCourseExists(userId, medicineId);
    }

    @Override
    public boolean updateCurrentCourse(CurrentCourse currentCourse) {
        return currentCourseDao.updateCurrentCourse(currentCourse);
    }

    @Override
    public boolean deleteCurrentCourse(CurrentCourse currentCourse) {
        return currentCourseDao.deleteCurrentCourse(currentCourse);
    }
}
