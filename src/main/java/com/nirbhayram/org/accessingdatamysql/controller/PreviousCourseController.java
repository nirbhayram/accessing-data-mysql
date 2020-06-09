package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.previouscourse.PreviousCourse;
import com.nirbhayram.org.accessingdatamysql.service.perviouscourse.IPreviousCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/previous-course")
public class PreviousCourseController {

    @Autowired
    private IPreviousCourseService previousCourseService;

    @GetMapping
    public ResponseEntity<List<PreviousCourse>> getPreviousCourse() {
        return null;
    }

}
