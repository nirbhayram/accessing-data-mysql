package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.application.Application;
import com.nirbhayram.org.accessingdatamysql.service.application.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/tza")
public class TrackzillaController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Void> addApplcaition(@RequestBody Application application, UriComponentsBuilder builder){
        boolean isApplicationAdded = applicationService.addApplication(application);
        if (isApplicationAdded){
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }



}
