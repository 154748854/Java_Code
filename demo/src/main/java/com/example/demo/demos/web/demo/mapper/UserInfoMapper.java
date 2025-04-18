package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from userinfo")
    List<UserInfo> selectAll();

    @Select("select * from userinfo where id= #{id}")
    UserInfo selectOne(Integer id);

    @Select("select * from userinfo where id= #{userId}")
    UserInfo selectOne2(@Param("userId") Integer id);

    // 返回自增id
    // keypro表示自增id赋值给那个字段
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone)" +
            "values(#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    //对insert参数进行重命名
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone)" +
            "values(#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

}
