package com.example.book.demos.web.controller;

import com.example.book.demos.web.model.BookInfo;
import com.example.book.demos.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    // 告诉Spring,从容器中取出这个对象,放在当前的对象中/或者说赋值给当前对象的属性
    @Autowired
    private BookService bookService;


    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList() {
        // 1. 获取图书的数据
        // 2. 对图书的数据进行处理
        // 3. 返回数据
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }

}
