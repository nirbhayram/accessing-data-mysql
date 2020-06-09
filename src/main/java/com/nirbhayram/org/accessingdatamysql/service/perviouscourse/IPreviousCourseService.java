package com.nirbhayram.org.accessingdatamysql.service.perviouscourse;

import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IPreviousCourseService {
    ResponseEntity<List<PreviousCourse>> getPreviousCourse(Map<Object, Object> map);
}
