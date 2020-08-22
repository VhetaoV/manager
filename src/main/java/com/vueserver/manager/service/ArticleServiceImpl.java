package com.vueserver.manager.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vueserver.manager.dao.ArticleDao;
import com.vueserver.manager.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

    public PageInfo queryByPage(Integer startPage, Integer pageSize){
        PageHelper.startPage(startPage,pageSize);
        List<Article> articleList = articleDao.selectAll();
        PageInfo<Article> pageInfo = PageInfo.of(articleList);
        return pageInfo;
    }
}
