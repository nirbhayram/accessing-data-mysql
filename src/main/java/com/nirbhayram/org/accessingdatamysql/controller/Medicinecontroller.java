package com.nirbhayram.org.accessingdatamysql.controller;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/name")
    public ResponseEntity<Medicine> getMedicineByName(@RequestParam String name){
        Medicine medicine = medicineService.getMedicineByName(name);
        if (null==medicine){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Medicine>(medicine,HttpStatus.FOUND);
        }
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Medicine> getMedicineById(@RequestParam int id){
        Medicine medicine = medicineService.getMedicineById(id);
        if (null==medicine){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Medicine>(medicine,HttpStatus.FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicine(){
        List<Medicine> medicineList = medicineService.getAllMedicine();
        if (null==medicineList || medicineList.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Medicine>>(medicineList,HttpStatus.FOUND);
        }
    }

}
