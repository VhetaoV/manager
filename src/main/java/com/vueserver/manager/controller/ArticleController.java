package com.vueserver.manager.controller;

import com.vueserver.manager.common.PageData;
import com.vueserver.manager.common.Result;
import com.vueserver.manager.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Result queryPage(){
        List<Article> list = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            Article article = new Article();
            article.setId((long)i);
            article.setTitle("title—"+i);
            article.setAuthor("chenliang"+i);
            article.setCreateDate(new Date());
            list.add(article);
        }
        PageData pageData = new PageData();
        pageData.setItems(list);
        pageData.setTotal(10);
        return Result.OK(pageData);
    }
}
