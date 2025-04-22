package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleInfoMapper {
    @Select("select * from articleinfo where id = #{articleId}")
    ArticleInfo selectById(Integer articleId);

    /**
     * 多表查询
     * @param articleId
     * @return
     */
    @Select("select ta.*, tb.username, tb.age from articleinfo ta" +
            " left join userinfo tb on ta.uid = tb.id" +
            " where ta.id = 1")
    ArticleInfo selectArticleAndUserById(Integer articleId);
}
