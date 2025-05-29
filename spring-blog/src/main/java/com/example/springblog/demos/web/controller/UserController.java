package com.example.springblog.demos.web.controller;

import com.example.springblog.demos.web.constant.Constants;
import com.example.springblog.demos.web.mapper.UserInfoMapper;
import com.example.springblog.demos.web.model.Result;
import com.example.springblog.demos.web.model.UserInfo;
import com.example.springblog.demos.web.service.UserService;
import com.example.springblog.demos.web.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String username, String password) {
        log.info("UserController#login接收到的参数: username:{}, password:{}",username,password);
        //1. 校验参数的合法性
        //2. 校验账号密码是否正确
        //3. 密码正确,返回token
        //4. 密码错误,返回错误信息
        if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return Result.fail("参数不合法");
        }
        // 从数据库中查找用户
        UserInfo userInfo = userService.selectByName(username);
        // 用户不存在
        if (userInfo == null) {
            log.error("用户不存在");
            return Result.fail("用户不存在");
        }
        // 密码错误
        if (!password.equals(userInfo.getPassword())) {
            log.error("密码错误");
            return Result.fail("密码错误");
        }
        // 密码正确,返回token
        Map<String,Object> claim = new HashMap<>();
        claim.put(Constants.TOKEN_ID,userInfo.getId());
        claim.put(Constants.TOKEN_USERNAME,userInfo.getUserName());
        String token = JwtUtils.genJwtToken(claim);
        log.info("UserController#login 返回的结果:token:{}",token);
        return Result.success(token);
    }

    /**
     * 获取当前登录用户的信息
     * @return
     */
    @RequestMapping("/getUserInfo")
    public UserInfo getLoginUserInfo(HttpServletRequest request) {
        // 获取token
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        // 从token中获取登录用户的ID
        Integer userId = JwtUtils.getIdByToken(token);
        if (userId==null) {
            // 用户未登录
            return null;
        }
        UserInfo userInfo = userService.selectById(userId);
        return userInfo;

    }

//    @RequestMapping("/getAuthorInfo")
//    public UserInfo getAuthorInfo(Integer blogId) {
//
//    }
}
