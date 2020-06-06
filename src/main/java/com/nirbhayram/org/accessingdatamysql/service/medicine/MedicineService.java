package com.nirbhayram.org.accessingdatamysql.service.medicine;

import com.nirbhayram.org.accessingdatamysql.dao.medicine.IMedicineDao;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService implements IMedcineService{

    @Autowired
    private IMedicineDao medicineDao;

    @Override
    public void addMedicine(Medicine medicine) {
        medicineDao.addMedicine(medicine);
    }

    @Override
    public Medicine getMedicineById(int id) {
        return medicineDao.getMedicineById(id);
    }

    @Override
    public Medicine getMedicineByName(String name) {
        return medicineDao.getMedicineByName(name);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineDao.getAllMedicine();
    }
}
