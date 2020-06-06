package com.nirbhayram.org.accessingdatamysql.service.medicine;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import java.util.List;

public interface IMedicineService {
    boolean addMedicine(Medicine medicine);
    Medicine getMedicineById(int id);
    Medicine getMedicineByName(String name);
    List<Medicine> getAllMedicine();
}
