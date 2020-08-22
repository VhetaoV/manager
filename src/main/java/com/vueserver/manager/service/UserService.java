package com.vueserver.manager.service;

import com.vueserver.manager.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUser(User user);
}
