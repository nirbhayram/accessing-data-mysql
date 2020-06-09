package com.nirbhayram.org.accessingdatamysql.service.perviouscourse;

import com.nirbhayram.org.accessingdatamysql.constant.Constant;
import com.nirbhayram.org.accessingdatamysql.dao.previouscourse.IPreviousCourseDao;
import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourse;
import com.nirbhayram.org.accessingdatamysql.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PreviousCourseService implements IPreviousCourseService {

    @Autowired
    IPreviousCourseDao previousCourseDao;

    @Override
    public ResponseEntity<List<PreviousCourse>> getPreviousCourse(Map<Object, Object> map) {
        int userId = RequestUtil.checkUserId(map);
        int medicineId = RequestUtil.checkMedicineId(map);
        if (userId == Constant.DEFAULT_FALSE_INT) {
            if (medicineId == Constant.DEFAULT_FALSE_INT) {
                return new ResponseEntity<List<PreviousCourse>>(previousCourseDao.getAllPreviousCourse(), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<List<PreviousCourse>>(previousCourseDao.getPreviousCourseOfMedicineId(medicineId), HttpStatus.FOUND);
            }
        } else {
            if (medicineId == Constant.DEFAULT_FALSE_INT) {
                return new ResponseEntity<List<PreviousCourse>>(previousCourseDao.getPreviousCourseOfUserId(userId), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<List<PreviousCourse>>(previousCourseDao.getPreviousCourseOfUserIdAndMedicineId(userId, medicineId), HttpStatus.FOUND);
            }
        }
    }
}
