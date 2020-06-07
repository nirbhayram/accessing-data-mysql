package com.nirbhayram.org.accessingdatamysql.service.currentcourse;

import com.nirbhayram.org.accessingdatamysql.dao.currentcourse.ICurrentCourseDao;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourse;
import com.nirbhayram.org.accessingdatamysql.entity.currentcourse.CurrentCourseID;
import com.nirbhayram.org.accessingdatamysql.entity.medicine.Medicine;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.requestmapping.CurrentCourseRequest;
import com.nirbhayram.org.accessingdatamysql.service.medicine.IMedicineService;
import com.nirbhayram.org.accessingdatamysql.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrentCourseService implements ICurrentCourseService {

    public static final int DEFAULT_FALSE = -789;

    @Autowired
    private ICurrentCourseDao currentCourseDao;

    @Autowired
    private IUserService userService;

    @Autowired
    private IMedicineService medicineService;

    @Override
    public ResponseEntity<String> addCurrentCourse(CurrentCourseRequest currentCourseRequest) {
        CurrentCourseID currentCourseID = new CurrentCourseID();
        User user = userService.getUserById(currentCourseRequest.getUserId());
        Medicine medicine = medicineService.getMedicineById(currentCourseRequest.getMedicineId());
        if (null == user || null == medicine) {
            return new ResponseEntity<String>("No user or medicine found", HttpStatus.NOT_FOUND);
        }
        currentCourseID.setUser(user);
        currentCourseID.setMedicine(medicine);
        CurrentCourse currentCourse = new CurrentCourse();
        currentCourse.setCurrentCourseID(currentCourseID);
        currentCourse.setDailyConsuption(currentCourseRequest.getDailyConsuption());
        currentCourse.setRemainingTablets(currentCourseRequest.getRemainingTablets());
        currentCourse.setStartedDate(currentCourseRequest.getStartedDate());
        currentCourseDao.addCurrentCourse(currentCourse);
        return new ResponseEntity<String>("Entry added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateCurrentCourse(CurrentCourseRequest currentCourseRequest) {
        CurrentCourse currentCourse = currentCourseDao.getCurrentCourseOfUserAndMedicine(currentCourseRequest.getUserId(), currentCourseRequest.getMedicineId());
        if (null == currentCourse) {
            return new ResponseEntity<String>("No match found", HttpStatus.NOT_FOUND);
        } else {
            updateCurrentCourse(currentCourse, currentCourseRequest);
            return new ResponseEntity<String>("Updatetd", HttpStatus.FOUND);
        }
    }

    private void updateCurrentCourse(CurrentCourse currentCourse, CurrentCourseRequest currentCourseRequest) {
        currentCourse.setDailyConsuption(currentCourseRequest.getDailyConsuption());
        currentCourse.setRemainingTablets(currentCourseRequest.getRemainingTablets());
        currentCourse.setStartedDate(currentCourseRequest.getStartedDate());
    }

    @Override
    public ResponseEntity<String> deleteCurrentCourse(CurrentCourseRequest currentCourseRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<CurrentCourse>> getAllCurrentCourse() {
        List<CurrentCourse> currentCourseList = currentCourseDao.getAllCurrentCourse();
        if (null == currentCourseList) {
            return new ResponseEntity<List<CurrentCourse>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<CurrentCourse>>(currentCourseList, HttpStatus.FOUND);
        }
    }

    @Override
    public ResponseEntity<List<CurrentCourse>> getCurrentCourseByUserId(int userId) {
        List<CurrentCourse> currentCourseList = currentCourseDao.getAllCurrentCourseOfUser(userId);
        if (null == currentCourseList) {
            return new ResponseEntity<List<CurrentCourse>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<CurrentCourse>>(currentCourseList, HttpStatus.FOUND);
        }
    }

    @Override
    public ResponseEntity<List<CurrentCourse>> getCurrentCourseByMedicineId(int medicineId) {
        List<CurrentCourse> currentCourseList = currentCourseDao.getAllCurrentCourseOfMedicine(medicineId);
        if (null == currentCourseList) {
            return new ResponseEntity<List<CurrentCourse>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<CurrentCourse>>(currentCourseList, HttpStatus.FOUND);
        }
    }

    @Override
    public ResponseEntity<CurrentCourse> getCurrentCourseByUserIdAndMedicineId(int userId, int medicineId) {
        CurrentCourse currentCourse = currentCourseDao.getCurrentCourseOfUserAndMedicine(userId, medicineId);
        if (null == currentCourse) {
            return new ResponseEntity<CurrentCourse>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<CurrentCourse>(currentCourse, HttpStatus.FOUND);
        }
    }

    @Override
    public ResponseEntity<List<CurrentCourse>> serveGetRequest(Map<Object, Object> map) {
        int userId = checkUserId(map);
        int medicineId = checkMedicineId(map);
        if (userId == DEFAULT_FALSE) {
            if (medicineId == DEFAULT_FALSE) {
                return this.getAllCurrentCourse();
            } else {
                return this.getCurrentCourseByMedicineId(medicineId);
            }
        } else {
            if (medicineId == DEFAULT_FALSE) {
                return this.getCurrentCourseByUserId(userId);
            } else {
                ResponseEntity<CurrentCourse> responseEntity = this.getCurrentCourseByUserIdAndMedicineId(userId, medicineId);
                List<CurrentCourse> list = new ArrayList<CurrentCourse>();
                list.add(responseEntity.getBody());
                return new ResponseEntity<List<CurrentCourse>>(list, HttpStatus.FOUND);
            }
        }
    }

    private int checkUserId(Map<Object, Object> map) {
        Object userIdObject = map.get("userId");
        if (null == userIdObject) {
            return DEFAULT_FALSE;
        } else {
            try {
                return Integer.parseInt(userIdObject.toString());
            } catch (Exception e) {
                return DEFAULT_FALSE;
            }
        }
    }

    private int checkMedicineId(Map<Object, Object> map) {
        Object medicineId = map.get("medicineId");
        if (null == medicineId) {
            return DEFAULT_FALSE;
        } else {
            try {
                return Integer.parseInt(medicineId.toString());
            } catch (Exception e) {
                return DEFAULT_FALSE;
            }
        }
    }

}
