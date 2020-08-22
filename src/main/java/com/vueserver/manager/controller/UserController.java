package com.vueserver.manager.controller;

import com.vueserver.manager.common.Result;
import com.vueserver.manager.entity.User;
import com.vueserver.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2019-11-23 17:34
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public Result login(User user){
        userService.findUser(user);
        return Result.OK();
    }

//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    @ResponseBody
//    public List<User> login(/*@RequestParam(value = "userName",required = true)*/ String userName,
//                            /*@RequestParam(value = "userPassword",required = true)*/ String userPassword){
//        User user = new User();
//        user.setUserName(userName);
//        user.setUserPassword(userPassword);
//        return userService.findUser(user);
//    }















}
