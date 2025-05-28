package com.example.springblog.demos.web.controller;

import com.example.springblog.demos.web.model.Result;
import com.example.springblog.demos.web.model.UserInfo;
import com.example.springblog.demos.web.service.UserService;
import com.example.springblog.demos.web.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String userName, String password) {
        //1. 校验参数的合法性
        //2. 校验账号密码是否正确
        //3. 密码正确,返回token
        //4. 密码错误,返回错误信息
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("参数不合法");
        }
        // 从数据库中查找用户
        UserInfo userInfo = userService.selectByName(userName);
        // 用户不存在
        if (userInfo == null) {
            return Result.fail("用户不存在");
        }
        // 密码错误
        if (!password.equals(userInfo.getPassword())) {
            return Result.fail("密码错误");
        }
        // 密码正确,返回token
        Map<String,Object> claim = new HashMap<>();
        claim.put("id",userInfo.getId());
        claim.put("userName",userInfo.getUserName());
        String token = JwtUtils.genJwtToken(claim);
        return Result.success(token);
    }
}
