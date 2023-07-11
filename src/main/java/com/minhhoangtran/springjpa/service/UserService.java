package com.minhhoangtran.springjpa.service;

import com.minhhoangtran.springjpa.entity.User;

public interface UserService {
    User getUser(Long id);

    User saveUser(User user);
}
