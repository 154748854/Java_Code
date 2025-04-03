package com.example.book.demos.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList() {
        // 1. 获取图书的数据
        // 2. 对图书的数据进行处理
        // 3. 返回数据
        List<BookInfo> bookInfos = mockData();
        // mock 表示的是虚拟的假数据, 是一个专业术语
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    private List<BookInfo> mockData() {
        // 优化的小Tip:
        // 对于已知的数据量,或者大概知道这个集合的数据量时,创建List事,建议指定初始值
        // 这样可以避免扩容,因为不指定的话,就是按照默认大小来进行
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("tushu"+i);
            bookInfo.setAuthor(""+i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStatus(i%5==0?2:1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
