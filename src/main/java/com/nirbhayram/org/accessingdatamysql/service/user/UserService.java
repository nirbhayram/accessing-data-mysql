package com.nirbhayram.org.accessingdatamysql.service.user;

import com.nirbhayram.org.accessingdatamysql.dao.user.IUserDao;
import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
