package com.example.captcha.demos.web.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@RestController
public class CaptchaController {
    // 企业标准:
    // 常量定义: 全大写,单词间用下划线分割   value: 通常是小写,下划线分割
    private static final String KAPTCHA_SESSION_KEY = "HOME_KAPTCHA_SESSION_KEY";
    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session) {
        if (!StringUtils.hasLength(captcha)) {
            return false;
        }
        // 从session中获取验证码
        String saveCaptcha = (String)session.getAttribute(KAPTCHA_SESSION_KEY);
        // 比对验证码

    }
}
