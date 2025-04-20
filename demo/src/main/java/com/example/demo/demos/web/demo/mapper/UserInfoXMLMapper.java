package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {
    List<UserInfo> selectAll();

    Integer insert(UserInfo userInfo);
    Integer insert2(@Param("userinfo") UserInfo userInfo);

    Integer delete(Integer id);

    Integer update(UserInfo userInfo);
}
