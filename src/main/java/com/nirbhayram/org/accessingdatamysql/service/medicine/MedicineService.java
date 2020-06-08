package com.nirbhayram.org.accessingdatamysql.service.medicine;

import com.nirbhayram.org.accessingdatamysql.constant.Constant;
import com.nirbhayram.org.accessingdatamysql.dao.medicine.IMedicineDao;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.requestmapping.MedicineRequest;
import com.nirbhayram.org.accessingdatamysql.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MedicineService implements IMedicineService {

    @Autowired
    private IMedicineDao medicineDao;

    @Override
    public ResponseEntity<String> addMedicine(MedicineRequest medicineRequest) {
        Medicine medicine = checkMedicineRequest(medicineRequest);
        try {
            medicineDao.addMedicine(medicine);
            return new ResponseEntity<String>("Medicne created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Medicne name conflicts", HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<List<Medicine>> getMedicine(Map<Object, Object> map) {
        String medicineName = RequestUtil.checkMedicineName(map);
        if (Constant.DEFAULT_NULL_STRING.equals(medicineName)) {
            return new ResponseEntity<List<Medicine>>(medicineDao.getAllMedicine(), HttpStatus.FOUND);
        } else {
            Medicine medicine = medicineDao.getMedicineByName(medicineName);
            if (null == medicine) {
                return new ResponseEntity<List<Medicine>>(HttpStatus.NOT_FOUND);
            } else {
                List<Medicine> list = new ArrayList<Medicine>();
                list.add(medicine);
                return new ResponseEntity<List<Medicine>>(list, HttpStatus.FOUND);
            }
        }
    }

    @Override
    public Medicine getMedicineById(int id) {
        return medicineDao.getMedicineById(id);
    }

    @Override
    public ResponseEntity<String> updateMedicine(MedicineRequest medicineRequest) {
        String medicineName = medicineRequest.getMedicineName();
        if (StringUtils.isEmpty(medicineName)){
            return new ResponseEntity<String>("No medicine found",HttpStatus.NOT_FOUND);
        }else{
            Medicine medicine = medicineDao.getMedicineByName(medicineName);
            if (null == medicine){
                return new ResponseEntity<String>("No medicine found",HttpStatus.NOT_FOUND);
            }else{
                updateMedicine(medicine,medicineRequest);
                medicineDao.addMedicine(medicine);
                return new ResponseEntity<String>("Medicine updated",HttpStatus.FOUND);
            }
        }
    }

    private void updateMedicine(Medicine medicine, MedicineRequest medicineRequest) {
        medicine.setDiscription(medicineRequest.getDiscription());
        medicine.setReason(medicineRequest.getReason());
    }

    private Medicine checkMedicineRequest(MedicineRequest medicineRequest) {
        Medicine medicine = new Medicine();
        medicine.setDiscription(medicineRequest.getDiscription());
        medicine.setMedicineName(medicineRequest.getMedicineName());
        medicine.setReason(medicineRequest.getReason());
        return medicine;
    }
}
