package com.nirbhayram.org.accessingdatamysql.utils;

import com.nirbhayram.org.accessingdatamysql.constant.Constant;

import java.util.Map;

public class RequestUtil {

    public static int checkUserId(Map<Object, Object> map) {
        Object userIdObject = map.get(Constant.userId);
        if (null == userIdObject) {
            return Constant.DEFAULT_FALSE_INT;
        } else {
            try {
                return Integer.parseInt(userIdObject.toString());
            } catch (Exception e) {
                return Constant.DEFAULT_FALSE_INT;
            }
        }
    }

    public static int checkMedicineId(Map<Object, Object> map) {
        Object medicineId = map.get(Constant.medicineId);
        if (null == medicineId) {
            return Constant.DEFAULT_FALSE_INT;
        } else {
            try {
                return Integer.parseInt(medicineId.toString());
            } catch (Exception e) {
                return Constant.DEFAULT_FALSE_INT;
            }
        }
    }

}
