package com.nirbhayram.org.accessingdatamysql.controller;


import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.request_mapping.UserRequest;
import com.nirbhayram.org.accessingdatamysql.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserById(@RequestParam Map<Object, Object> map) {
        return userService.getUser(map);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest,@RequestParam Map<Object, Object> map){
        return userService.updateUser(userRequest,map);
    }
}