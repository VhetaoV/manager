package com.vueserver.manager.controller;

import com.github.pagehelper.PageInfo;
import com.vueserver.manager.common.PageData;
import com.vueserver.manager.common.Result;
import com.vueserver.manager.entity.Article;
import com.vueserver.manager.param.ArticleParam;
import com.vueserver.manager.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@EnableTransactionManagement
public class ArticleController implements ArticleControllerInter{


    @Resource
    private ArticleService articleService;
    @Transactional
    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    @ResponseBody
    public Result queryPage(@RequestParam(value = "page", required = true, defaultValue = "1") Integer startPage,
                            @RequestParam(value = "limit", required = true, defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "title", required = false) String title){
        PageInfo pageInfo = articleService.queryByPage(startPage,pageSize,title);
        PageData pageData = new PageData(pageInfo.getList(),pageInfo.getTotal());
        return Result.OK(pageData);
    }

    @PostMapping("/createArticle")
    @ResponseBody
   public Result createArticle(@RequestBody ArticleParam articleParam){
        return Result.OK(articleService.createArticle(articleParam));
   }
}
