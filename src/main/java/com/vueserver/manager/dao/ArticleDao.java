package com.vueserver.manager.dao;

import com.vueserver.manager.entity.Article;
import com.vueserver.manager.param.ArticleParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ArticleDao {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> selectByPage(String title);

    int createArticle(ArticleParam articleParam);
}