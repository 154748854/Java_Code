package com.example.book.demos.web.mapper;

import com.example.book.demos.web.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    UserInfo selectUserByName(String name);
}
