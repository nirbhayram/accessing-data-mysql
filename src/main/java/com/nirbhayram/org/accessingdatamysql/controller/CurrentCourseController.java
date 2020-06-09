package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.request_mapping.CurrentCourseRequest;
import com.nirbhayram.org.accessingdatamysql.service.currentcourse.ICurrentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/current-course")
public class CurrentCourseController {

    @Autowired
    private ICurrentCourseService currentCourseService;

    @PostMapping
    public ResponseEntity<String> addCurrentCourse(@RequestBody CurrentCourseRequest currentCourseRequest) {
        return currentCourseService.addCurrentCourse(currentCourseRequest);
    }

    @GetMapping
    public ResponseEntity<List<CurrentCourse>> getAllCurrentCourse(@RequestParam Map<Object, Object> map) {
        return currentCourseService.serveGetRequest(map);
    }

    @PutMapping
    public ResponseEntity<String> updateCurrentCourse(@RequestBody CurrentCourseRequest currentCourseRequest) {
        return currentCourseService.addCurrentCourse(currentCourseRequest);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCurrentCourse(@RequestBody CurrentCourseRequest currentCourseRequest) {
        return currentCourseService.deleteCurrentCourse(currentCourseRequest);
    }

}
