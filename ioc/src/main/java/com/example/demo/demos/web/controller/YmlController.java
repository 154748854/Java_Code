//package com.example.demo.demos.web.controller;
////
////import com.example.demo.demos.web.model.DBType;
////import com.example.demo.demos.web.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//
//@RestController
//public class YmlController {
//    @Value("${demo.key1}")
//    public String key1;
//
//    @Value("${demo.key2}")
//    public String key2;
//
//    @Value("${demo.key3}")
//    public String key3;
//
//    @RequestMapping("/readYml")
//    public String readYml() {
//        return "key1:"+key1;
//    }
////
////    @Autowired
////    public Student student;
//    // 在对外进行服务之前,会先执行postConstruct方法
//
////    @Autowired
////    public DBType dbType;
////
////    @PostConstruct
////    public void init() {
//////        System.out.println("key:"+key1+""+key2+""+key3);
//////        System.out.println(key3==null);
////        System.out.println(student);
////        System.out.println(dbType);
////    }
//}
