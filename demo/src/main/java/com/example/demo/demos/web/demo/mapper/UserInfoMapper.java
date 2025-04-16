package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from userinfo")
    List<UserInfo> selectAll();

}
