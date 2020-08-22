package com.vueserver.manager.service;

import com.github.pagehelper.PageInfo;
import com.vueserver.manager.param.ArticleParam;

public interface ArticleService {

    PageInfo queryByPage(Integer startPage, Integer pageSize, String title);


    int createArticle(ArticleParam articleParam);
}
