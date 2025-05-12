package com.example.book.demos.web.controller;

import com.example.book.demos.web.constant.Constants;
import com.example.book.demos.web.enums.ResultCode;
import com.example.book.demos.web.mapper.BookInfoMapper;
import com.example.book.demos.web.mapper.UserInfoMapper;
import com.example.book.demos.web.model.*;
import com.example.book.demos.web.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.List;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    // 告诉Spring,从容器中取出这个对象,放在当前的对象中/或者说赋值给当前对象的属性
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session) {
        log.info("查询翻页信息, pageRequest:{}", pageRequest);
        // 用户登录校验
//        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//        if (userInfo==null || userInfo.getId()<=0 || "".equals(userInfo.getUserName())) {
//            // 用户未登录
//            return Result.unlogin();
//        }
        // 校验成功
        if (pageRequest.getCurrentPage()<1 || pageRequest.getPageSize()<0) {
            return Result.fail("参数校验失败");
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try {
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
            return Result.success(bookInfoPageResult);
        }catch (Exception e) {
            log.error("查询翻页信息错误,e:{}",e);
            return Result.fail(e.getMessage());
        }
    }


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("接受到添加图书请求,bookInfo:{}",bookInfo);
        // 参数校验
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount()<0
                || bookInfo.getPrice() == null
                || !StringUtils.hasLength(bookInfo.getPublish())) {
            return "参数校验失败,请检查入参";
        }
        Integer result = bookService.addBook(bookInfo);
        if (result <=0) {
            log.error("添加图书出错:bookInfo:{}",bookInfo);
            return "添加图书出错,请联系管理员";
        }
        return "";
    }


    @RequestMapping("/queryBookInfoById")
    public BookInfo queryBookInfoById(Integer bookId) {
        log.info("根据Id查询图书");

        // 校验成功
        try {
            BookInfo bookInfo = bookService.queryBookInfoById(bookId);
            return bookInfo;
        }catch (Exception e) {
            log.error("查询图书失败,e:{}",e);
        }

        return null;
    }


    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("接收到更新图书的请求");
        Integer result = bookService.updateBook(bookInfo);
        if (result == 0) {
            log.error("更新图书失败,请联系管理员");
            return "更新图书失败,请联系管理员";
        }
        return "";
    }

    @RequestMapping("/batchDelete")
    public String batchDelete(@RequestParam List<Integer> ids) {
        log.info("接收到批量删除请求.图书ID:{}",ids);
        Integer result = bookService.batchDelete(ids);
        if (result<=0) {
            log.error("批量删除失败,请联系管理员");
            return "批量删除失败,请联系管理员";
        }
        return "";
    }

}
