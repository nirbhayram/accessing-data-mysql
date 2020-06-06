package com.nirbhayram.org.accessingdatamysql.service.medicine;

import com.nirbhayram.org.accessingdatamysql.dao.medicine.IMedicineDao;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService implements IMedicineService {

    @Autowired
    private IMedicineDao medicineDao;

    @Override
    public boolean addMedicine(Medicine medicine) {
        if (null == medicineDao.getMedicineByName(medicine.getMedicineName())) {
            medicineDao.addMedicine(medicine);
            return true;
        }
        return false;
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
