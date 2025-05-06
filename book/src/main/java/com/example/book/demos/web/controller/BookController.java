package com.example.book.demos.web.controller;

import com.example.book.demos.web.model.BookInfo;
import com.example.book.demos.web.model.PageRequest;
import com.example.book.demos.web.model.PageResult;
import com.example.book.demos.web.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    // 告诉Spring,从容器中取出这个对象,放在当前的对象中/或者说赋值给当前对象的属性
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        log.info("查询翻页信息, pageRequest:{}", pageRequest);

        if (pageRequest.getCurrentPage()<1 || pageRequest.getPageSize()<0) {
            return null;
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try {
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
        }catch (Exception e) {
            log.error("查询翻页信息错误,e:{}",e);
        }
        return bookInfoPageResult;
    }
}
