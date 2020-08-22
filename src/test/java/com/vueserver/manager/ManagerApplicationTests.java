package com.vueserver.manager;

import com.vueserver.manager.dao.UserDao;
import com.vueserver.manager.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserDao userDao;

    @Test
    public void testLogin(){
        User user = new User();
        user.setUserName("admin");
        user.setUserPassword("admin");
        List<User> list = userDao.findUser(user);
        System.err.println(list.get(0).getUserName());
    }
}
