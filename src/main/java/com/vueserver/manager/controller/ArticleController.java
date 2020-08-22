package com.vueserver.manager.controller;

import com.github.pagehelper.PageInfo;
import com.vueserver.manager.common.PageData;
import com.vueserver.manager.common.Result;
import com.vueserver.manager.entity.Article;
import com.vueserver.manager.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2020-06-06 18:04
 **/
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {


    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    @ResponseBody
    public Result queryPage(@RequestParam(value = "page", required = true, defaultValue = "1") Integer startPage,
                            @RequestParam(value = "limit", required = true, defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "title", required = false) String title){
        PageInfo pageInfo = articleService.queryByPage(startPage,pageSize,title);
        PageData pageData = new PageData(pageInfo.getList(),pageInfo.getTotal());
        return Result.OK(pageData);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Result queryPage(){
        List<Article> list = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            Article article = new Article();
            article.setId((long)i);
            article.setAuthor("chenliang"+i);
            article.setCreateDate(new Date());
            list.add(article);
        }
        PageData pageData = new PageData();
        pageData.setItems(list);
        pageData.setTotal(10L);
        return Result.OK(pageData);
    }
}
