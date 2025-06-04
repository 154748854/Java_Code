package com.example.springblog.demos.web.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class SecurityUtils {
    /**
     * 加密
     * password 用户注册时输入的密码(明文
     * return: 数据库中存储的信息 盐值 + md5(明文+盐值进行md5加密)
     */
    public static String encrypt(String password) {
        // 生成随机盐值
        String salt = UUID.randomUUID().toString().replace("-","");
        // 对 明文+盐值 进行md5加密, => 得到MD5(明文+盐值)
        String finalPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        return salt+finalPassword;
    }

    /**
     * 验证密码是否正确
     * @param inputPassword 用户登录时输入的密码
     * @param sqlPassword  数据库中password存储的信息:盐值 + md5(明文+盐值进行md5加密)
     * @return
     */
    public static boolean verify(String inputPassword, String sqlPassword) {
        if (StringUtils.hasLength(inputPassword)) {
            return false;
        }
        if (sqlPassword==null || sqlPassword.length()!=64) {
            return false;
        }
        // 获取盐值,左闭右开
        String salt = sqlPassword.substring(0,32);
        // 将用户此时输入的密码根据数据库中的盐值进行MD5加密,  MD5(明文+盐值)
        String finalPassword = DigestUtils.md5DigestAsHex((inputPassword+salt).getBytes());
        return (salt+finalPassword).equals(sqlPassword);
    }
}
