package com.nirbhayram.org.accessingdatamysql.dao.medicine;

import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicineDao implements IMedicineDao{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public Medicine getMedicineById(int id) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isEmpty()){
            return null;
        }
        return optionalMedicine.get();
    }

    @Override
    public Medicine getMedicineByName(String name) {
        return medicineRepository.findByMedicineName(name);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        Iterable<Medicine> iterable = medicineRepository.findAll();
        Iterator<Medicine> iterator = iterable.iterator();
        List<Medicine> medicineList = new ArrayList<>();
        while (iterator.hasNext()){
            medicineList.add(iterator.next());
        }
        return medicineList;
    }
}
