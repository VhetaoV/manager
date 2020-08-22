package com.vueserver.manager.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: hetao
 * @create: 2020-06-06 18:05
 **/
@Data
public class Article {

    private Long id;
    private String title;
    private String author;
    private String imp;
    private Date createDate;
    private Integer readings;
    private Boolean status;
}
