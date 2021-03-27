package com.vueserver.manager.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vueserver.manager.dao.ArticleDao;
import com.vueserver.manager.dao.UserDao;
import com.vueserver.manager.entity.Article;
import com.vueserver.manager.entity.User;
import com.vueserver.manager.param.ArticleParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2020-08-22 15:57
 **/
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;
    @Resource
    private UserDao userDao;

    @Override
    public PageInfo queryByPage(Integer startPage, Integer pageSize, String title){
        PageHelper.startPage(startPage,pageSize);
        List<Article> articleList = articleDao.selectByPage(title);
        PageInfo<Article> pageInfo = PageInfo.of(articleList);
        return pageInfo;
    }

    @Override
    public int createArticle(ArticleParam articleParam) {
        return articleDao.createArticle(articleParam);
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
        return 1;
    }
}
