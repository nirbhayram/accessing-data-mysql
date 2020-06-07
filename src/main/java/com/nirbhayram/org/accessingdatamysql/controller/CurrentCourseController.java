package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentcourseRepository;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.requestmapping.CurrentCourseRequest;
import com.nirbhayram.org.accessingdatamysql.service.medicine.MedicineService;
import com.nirbhayram.org.accessingdatamysql.service.user.UserService;
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
    private CurrentcourseRepository currentcourseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<String> addCurrentCourse(@RequestBody CurrentCourseRequest currentCourseRequest) {
//        System.out.println(currentCourseRequest.getUserId() + " " +
//                currentCourseRequest.getMedicineId() + " " +
//                currentCourseRequest.getStartedDate()+" "+
//                currentCourseRequest.getDailyConsuption()+" "+
//                currentCourseRequest.getRemainingTablets());
        CurrentCourseID currentCourseID = new CurrentCourseID();
        User user = userService.getUserById(currentCourseRequest.getUserId());
        Medicine medicine = medicineService.getMedicineById(currentCourseRequest.getMedicineId());
        if (null==user || null==medicine){
            return new ResponseEntity<String>("No user or medicine found",HttpStatus.NOT_FOUND);
        }
        currentCourseID.setUser(user);
        currentCourseID.setMedicine(medicine);
        CurrentCourse currentCourse = new CurrentCourse();
        currentCourse.setCurrentCourseID(currentCourseID);
        currentCourse.setDailyConsuption(currentCourseRequest.getDailyConsuption());
        currentCourse.setRemainingTablets(currentCourseRequest.getRemainingTablets());
        currentCourse.setStartedDate(currentCourseRequest.getStartedDate());
        currentcourseRepository.save(currentCourse);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
