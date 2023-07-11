package com.minhhoangtran.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
