package com.example.book.demos.web.interceptor;

import com.example.book.demos.web.constant.Constants;
import com.example.book.demos.web.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 目标方法执行前执行,相当于安保查证件  返回true,放行,继续后续操作  false,拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("目标方法执行前");
        // 获取session并且判断session中存储的userinfo信息是否为空
        HttpSession session = request.getSession(true);
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if (userInfo==null || userInfo.getId()<=0) {
            // 用户未登录
            response.setStatus(401);
            return false;
        }
        return true;
    }

    // 目标方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法执行后");

    }


}
