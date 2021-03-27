package com.vueserver.manager.service;

import com.vueserver.manager.dao.UserDao;
import com.vueserver.manager.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2019-11-23 17:33
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;

    @Override
    public List<User> findUser(@RequestBody User user) {
        return userDao.findUser(user);
    }

    /**
     * <pre>
     * 分两种情况 1、事务不嵌套 每次执行方法save的时候都会开启一个新的事务
     * 2、事务嵌套 外层事务如果开启，内层事务会加入到外层事务中,此时如果 外层事务回滚，则内层事务会一同回滚,
     * 如果内层事务回滚、外层事务也会一同回滚。。。。因为他俩就是同一个事务啊
     * </pre>
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(User userParam) {
        log.info("开始执行 save {}, {}", userParam.getId(), userParam.getUserName());
        userDao.insert(userParam);
        try {
            log.info("save 完成---数据库中的值为 {} 开始 sleep", userParam.getUserName());
            // if ("15210712347".equals(userParam.getPhone())) {
            // throw new RuntimeException();
            // }
            Thread.sleep(1000);
            this.update(userParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * REQUIRES_NEW 如果已经存在老事务，则新事务会被挂起，直到老事务执行完成以后才执行新的事务<br/>
     * 注意： 并不是新事务把等着老事务把update方法的所有code都执行完才开始执行新事物的update方法<br/>
     * 因为只有执行到userMapper.update(userParam)才开启事务, 此时才会挂起老的事务
     */
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public Integer update(User userParam) {
        log.info("开始执行 update {}, {}", userParam.getId(), userParam.getUserName());
        userParam.setId(7);
        userParam.setUserName("coffee");
        int result = userDao.updateByPrimaryKey(userParam);
        try {
            log.info("update 完成---数据库中的值为 {} 开始 sleep");
            Thread.sleep(1000 * 10);
            log.info("sleep结束");
            throw new RuntimeException(); // 回滚
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
