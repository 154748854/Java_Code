package com.example.springtrans.demos.web.controller;


import com.example.springtrans.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trans")
@RestController
public class TransController {
    @Autowired
    private UserService userService;

    /**
     * 对异常进行捕获,事务不会回滚
     * @return
     */
    @Transactional
    @RequestMapping("/register")
    public boolean register(String userName, String password) {
        Integer result = userService.insert(userName,password);
        System.out.println("输入用户表,result "+result);
        try {
            int a =10/0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * 将异常抛出去,事务回滚
     */
    @Transactional
    @RequestMapping("/r2")
    public boolean r2(String userName, String password) {
        Integer result = userService.insert(userName,password);
        System.out.println("输入用户表,result "+result);
        try {
            int a =10/0;
        }catch (Exception e) {
            throw e;
        }
        return true;
    }
}
