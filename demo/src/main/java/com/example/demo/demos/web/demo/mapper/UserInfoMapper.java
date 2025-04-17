package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from userinfo")
    List<UserInfo> selectAll();

    @Select("select * from userinfo where id= #{id}")
    UserInfo selectOne(Integer id);

    @Select("select * from userinfo where id= #{userId}")
    UserInfo selectOne2(@Param("userId") Integer id);

}
