package com.example.demo.demos.web.demo.mapper;

import com.example.demo.demos.web.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select id, username, password, age, gender, phone,"+
            " delete_flag as deleteFlag, create_time as createTime, update_time as updateTime"+
            " from userinfo")
    List<UserInfo> selectAll();

    // 方法二. 通过注解映射不一致的名称
    @Results(id = "BaseMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "delete_time", property = "updateTime")

    })
    @Select("select * from userinfo")
    List<UserInfo> selectAll2();


    /**
     * 方法三: 使用配置的方式,自动转驼峰
     * @param
     * @return
     */
    @Select("select * from userinfo")
    List<UserInfo> selectAll3();
    @ResultMap(value = "BaseMap")
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

    // 这里之所以要对参数钱加一个什么什么. 那是因为我们对参数进行了重命名, mybatis并不知道我们是对什么进行重命名(对象?属性?
    // 所以我们只要在参数前加上一个点,就知道是对对象进行的重命名(这是个人理解, 就是 对象.属性
    // 一个是在xml中实现 一个是在注解中实现
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into userinfo (username,password,age,gender,phone)" +
            "values(#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender},#{userInfo.phone})")
    Integer insert2(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from userinfo where id = #{id}")
    Integer delete(Integer id);

    @Update("update userinfo set age=#{age} where id=#{id}")
    Integer update(UserInfo userInfo);

}
