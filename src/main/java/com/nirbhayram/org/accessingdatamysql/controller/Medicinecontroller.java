package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/medicine")
public class Medicinecontroller {

    @Autowired
    private IMedicineService medicineService;

    @PostMapping
    public ResponseEntity<Void> addMedicine(@RequestBody Medicine medicine) {
        if (medicineService.addMedicine(medicine)) {
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
        }
    }

}
