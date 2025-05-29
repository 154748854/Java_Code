package com.example.springblog.demos.web.interceptor;

import com.example.springblog.demos.web.constant.Constants;
import com.example.springblog.demos.web.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取token
        // 2. 校验token,判断是否放行
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        log.info("从header中获取token:{}",token);
        Claims claims = JwtUtils.parseToken(token);
        if (claims==null) {
            // 校验失败
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
