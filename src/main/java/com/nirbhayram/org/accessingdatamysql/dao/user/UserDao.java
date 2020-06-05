package com.nirbhayram.org.accessingdatamysql.dao.user;

import com.nirbhayram.org.accessingdatamysql.entity.user.User;
import com.nirbhayram.org.accessingdatamysql.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UserDao implements IUserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        Iterable<User> userIterable = userRepository.findAll();
        Iterator<User> userIterator = userIterable.iterator();
        List<User>  userList = new ArrayList<>();
        while (userIterator.hasNext()){
            userList.add(userIterator.next());
        }
        return userList;
    }

}
