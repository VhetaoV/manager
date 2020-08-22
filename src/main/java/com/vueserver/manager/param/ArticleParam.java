package com.vueserver.manager.param;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: hetao
 * @create: 2020-08-22 21:25
 **/
@Data
public class ArticleParam {

    private String author;
    private String title;
    private Date createDate = new Date();
    private Integer readings = 0;
    private Integer status = 0;
    private String content;
}
