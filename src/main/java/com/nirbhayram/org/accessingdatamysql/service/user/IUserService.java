package com.nirbhayram.org.accessingdatamysql.service.user;

import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.requestmapping.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserService {
    ResponseEntity<String> addUser(UserRequest userRequest);

    ResponseEntity<List<User>> getUser(Map<Object, Object> id);

    User getUserById(int userId);

    ResponseEntity<String> updateUser(UserRequest userRequest, Map<Object, Object> map);
}
