package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 动态sql
 */
@Mapper
public interface UserInfo2Mapper {
    @Insert("<script>" +
            "insert into userinfo (username,password,age," +
            "<if test = 'gender != null'> gender, </if>" +
            "phone)" +
            "values(#{username},#{password},#{age}," +
            "<if test= 'gender!=null'> #{gender}, </if>" +
            "#{phone})" +
            "</script>")
    Integer insert(UserInfo userInfo);

    Integer insertByXML(UserInfo userInfo);

    List<UserInfo> selectByCondition(UserInfo userInfo);
    List<UserInfo> selectByCondition2(UserInfo userInfo);


    List<UserInfo> updateByCondition(UserInfo userInfo);

    List<UserInfo> batchDelete(List<Integer> ids);

}
