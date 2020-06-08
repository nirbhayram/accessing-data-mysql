package com.nirbhayram.org.accessingdatamysql.service.medicine;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.request_mapping.MedicineRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IMedicineService {
    ResponseEntity<String> addMedicine(MedicineRequest medicineRequest);
    ResponseEntity<List<Medicine>> getMedicine(Map<Object,Object> map);
    Medicine getMedicineById(int id);
    ResponseEntity<String> updateMedicine(MedicineRequest medicineRequest);
}
