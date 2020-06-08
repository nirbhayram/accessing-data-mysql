package com.nirbhayram.org.accessingdatamysql.service.user;

import com.nirbhayram.org.accessingdatamysql.constant.Constant;
import com.nirbhayram.org.accessingdatamysql.dao.user.IUserDao;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.request_mapping.UserRequest;
import com.nirbhayram.org.accessingdatamysql.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public ResponseEntity<String> addUser(UserRequest userRequest) {
        User user = checkUserRequest(userRequest);
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong. Please try it again after some time",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("User created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<User>> getUser(Map<Object, Object> map) {
        int userId = RequestUtil.checkUserId(map);
        if (userId == Constant.DEFAULT_FALSE_INT) {
            return new ResponseEntity<List<User>>(userDao.getAllUser(), HttpStatus.FOUND);
        } else {
            User user = userDao.findUserById(userId);
            if (null == user) {
                return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
            } else {
                List<User> list = new ArrayList<User>();
                list.add(user);
                return new ResponseEntity<List<User>>(list, HttpStatus.FOUND);
            }
        }
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public ResponseEntity<String> updateUser(UserRequest userRequest, Map<Object, Object> map) {
        int userId = RequestUtil.checkUserId(map);
        if (userId == Constant.DEFAULT_FALSE_INT) {
            return new ResponseEntity<String>("No userId param found.", HttpStatus.BAD_REQUEST);
        } else {
            User user = checkUserUpdate(userRequest, userId);
            if (null == user) {
                return new ResponseEntity<String>("No user found", HttpStatus.NOT_FOUND);
            } else {
                try {
                    userDao.addUser(user);
                    return new ResponseEntity<String>("User updated",HttpStatus.FOUND);
                } catch (Exception e) {
                    return new ResponseEntity<String>("Something went wrong. Please try it again after some time",
                            HttpStatus.BAD_REQUEST);
                }
            }
        }
    }

    private User checkUserUpdate(UserRequest userRequest, int userId) {
        User user = userDao.findUserById(userId);
        if (null==user){
            return user;
        }else{
            user.setDateOfBirth(userRequest.getDateOfBirth());
            user.setPlace(userRequest.getPlace());
            user.setMobile(userRequest.getMobile());
            user.setName(userRequest.getName());
            return user;
        }
    }

    private User checkUserRequest(UserRequest userRequest) {
        User user = new User();
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setMobile(userRequest.getMobile());
        user.setName(userRequest.getName());
        user.setPlace(userRequest.getPlace());
        return user;
    }
}
