package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.pojo.CurrentCourseRequest;
import com.nirbhayram.org.accessingdatamysql.service.currentcourse.ICurrentCourseService;
import com.nirbhayram.org.accessingdatamysql.service.medicine.IMedicineService;
import com.nirbhayram.org.accessingdatamysql.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/current-course")
public class CurrentCourseController {

    @Autowired
    private ICurrentCourseService currentCourseService;

    @Autowired
    private IMedicineService medicineService;

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<String> addCurrentCourse(@RequestBody CurrentCourseRequest currentCourseRequest) {
        System.out.println(currentCourseRequest.getUserid() + "***********");
        User user = userService.getUserById(currentCourseRequest.getUserid());
        if (null == user) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
        Medicine medicine = medicineService.getMedicineById(currentCourseRequest.getMedicineid());
        if (null == medicine) {
            return new ResponseEntity<>("Medicine not found", HttpStatus.NOT_FOUND);
        }
        CurrentCourse currentCourse = new CurrentCourse();
        CurrentCourseID currentCourseID = new CurrentCourseID(user.getId(),medicine.getId());
        currentCourse.setCurrentCourseID(currentCourseID);
        currentCourse.setRemainingTablets(currentCourseRequest.getRemainingTablets());
        currentCourse.setDailyConsuption(currentCourseRequest.getDailyConsuption());
        boolean isCurrentCourseAdded = currentCourseService.addCurrentCourse(currentCourse);
        if (isCurrentCourseAdded) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
