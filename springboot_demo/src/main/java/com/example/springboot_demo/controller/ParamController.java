package com.example.springboot_demo.controller;

import com.example.springboot_demo.model.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/param")
@RestController
public class ParamController {
    @RequestMapping("/m1")
    public String m1(String name) {
        return "接收到的参数:" + name;
    }

    @RequestMapping("/m2")
    public String m2(String name, Integer age) {
        return "接收到的参数:" + name + " age:" + age;
    }

    @RequestMapping("/m5")
    public String m5(@RequestParam(value = "name",required = false) String username) {
        return "接受到的参数name:"+username;
    }

    @RequestMapping("/m6")
    public String m6(String[] arrayParam) {
        return "接收到的参数arrayParam:"+ Arrays.toString(arrayParam)+", 长度"+arrayParam.length;
    }

    @RequestMapping("/m7")
    public String m7(@RequestParam(required = false) List<String> listParam) {
        return "接受到的参数listParam"+listParam+", 长度"+listParam.size();
    }

    @RequestMapping("/m8")
    public String m8(@RequestBody Person person) {
        return "接收到的数据person:" + person.toString();
    }

    @RequestMapping("/m9/{userId}/{name}")
    public String m9(@PathVariable Integer userId,@PathVariable("name") String userName) {
        return "userId" + userId + " username"+userName;
    }
    @RequestMapping("/m10")
    public String m10(@RequestPart MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:\\"+file.getOriginalFilename()));
        return "success";
    }

    // 开发中这种使用的比较多欧
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName()+":"+cookie.getValue());
//        }
        if (cookies != null) {
            Arrays.stream(cookies).forEach(cookie -> {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            });
        }
        return "获取cookie成功";
    }
    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue String bite) {

        return "获取cookie成功"+bite;
    }

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username","zhangsan");
        return "success";
    }
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            String username = (String) session.getAttribute("username");
            return "登录用户"+username;
        }
        return "session为空";
    }
    @RequestMapping("/getSession2")
    public String getSession2(@SessionAttribute(required = false) String username) {
        return "username"+username;
    }
}
