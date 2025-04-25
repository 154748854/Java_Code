package com.example.springboot_demo.controller;

import com.example.springboot_demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/return")
@Controller
public class ReturnController {
    @RequestMapping("/index")
    public String returnIndex() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData() {
        return "返回视图需要的数据";
    }

    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml() {
        return "<h1>返回HTML代码片段</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public Person returnJson() {
        Person person = new Person();
        person.setAge(18);
        person.setName("zhangsan");
        return person;
    }

    @ResponseBody
    @RequestMapping("/returnMap")
    public Map<String,String> returnMap() {
        Map<String,String> kv = new HashMap<>();
        kv.put("k1","v1");
        kv.put("k2","v3");
        kv.put("k3","v3");
        return kv;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(401);
        return "设置状态码";
    }

    @ResponseBody
    @RequestMapping(value = "/r1", produces = "application/json;charset=utf8")
    public String r1(HttpServletResponse response) {
        // 设置状态码
        response.setHeader("myheader","myheader");
        return "{'OK':1}";
    }
}
