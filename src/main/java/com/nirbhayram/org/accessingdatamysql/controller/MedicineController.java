package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.MedicineRepository;
import com.nirbhayram.org.accessingdatamysql.requestmapping.MedicineRequest;
import com.nirbhayram.org.accessingdatamysql.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/medicine")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    @PostMapping
    public ResponseEntity<String> addMedicine(@RequestBody MedicineRequest medicineRequest){
        return medicineService.addMedicine(medicineRequest);
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getMedicine(@RequestParam Map<Object,Object> map){
        return medicineService.getMedicine(map);
    }

    @PutMapping
    public ResponseEntity<String> updateMedicine(@RequestBody MedicineRequest medicineRequest){
        return medicineService.updateMedicine(medicineRequest);
    }

}
