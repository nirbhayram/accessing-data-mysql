package com.nirbhayram.org.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import com.nirbhayram.org.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}