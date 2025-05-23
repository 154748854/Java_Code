package com.example.springblog.demos.web.mapper;

import com.example.springblog.demos.web.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    /**
     * 返回博客列表
     * @return
     */
    @Select("select * from blog where delete_flag != 1")
    List<BlogInfo> selectAll();

    /**
     * 根据博客id,返回博客信息
     * @return
     */
    @Select("select * from blog where delete_flag != 1 and id = #{id}")
    BlogInfo selectById(Integer id);

    /**
     * 更新博客
     * @return
     */
    Integer updateBlog(BlogInfo blogInfo);

    /**
     * 发布博客
     * @return
     */
    @Insert("insert into blog (title, content, user_id) values (#{title}, #{content}, #{userId})")
    Integer insertBlog(BlogInfo blogInfo);
}
