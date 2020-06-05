package com.nirbhayram.org.accessingdatamysql.dao.user;

import com.nirbhayram.org.accessingdatamysql.entity.user.User;

import java.util.List;

public interface IUserDao {
    void addUser(User user);
    User findUserById(int id);
    List<User> getAllUser();
}
