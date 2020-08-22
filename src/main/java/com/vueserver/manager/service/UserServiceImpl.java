package com.vueserver.manager.service;

import com.vueserver.manager.dao.UserDao;
import com.vueserver.manager.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2019-11-23 17:33
 **/
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findUser(@RequestBody User user) {
        return userDao.findUser(user);
    }
}
