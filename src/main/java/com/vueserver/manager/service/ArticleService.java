package com.vueserver.manager.service;

import com.github.pagehelper.PageInfo;

public interface ArticleService {

    PageInfo queryByPage(Integer startPage, Integer pageSize);
}
