package com.nirbhayram.org.accessingdatamysql.service.currentcourse;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.request_mapping.CurrentCourseRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ICurrentCourseService {

    ResponseEntity<String> addCurrentCourse(CurrentCourseRequest currentCourseRequest);

    ResponseEntity<String> updateCurrentCourse(CurrentCourseRequest currentCourseRequest);

    ResponseEntity<String> deleteCurrentCourse(CurrentCourseRequest currentCourseRequest);

    ResponseEntity<List<CurrentCourse>> getAllCurrentCourse();

    ResponseEntity<List<CurrentCourse>> getCurrentCourseByUserId(int userId);

    ResponseEntity<List<CurrentCourse>> getCurrentCourseByMedicineId(int medicineId);

    ResponseEntity<CurrentCourse> getCurrentCourseByUserIdAndMedicineId(int userId, int medicineId);


    ResponseEntity<List<CurrentCourse>> serveGetRequest(Map<Object, Object> map);
}
