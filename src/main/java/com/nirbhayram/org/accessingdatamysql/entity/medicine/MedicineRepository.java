package com.nirbhayram.org.accessingdatamysql.entity.medicine;

import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine,Integer> {
    Medicine findByMedicineName(String name);
}
