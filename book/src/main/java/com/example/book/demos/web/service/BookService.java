package com.example.book.demos.web.service;

import com.example.book.demos.web.dao.BookDao;
import com.example.book.demos.web.model.BookInfo;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<BookInfo> getBookList() {
        List<BookInfo> bookInfos = bookDao.mockData();
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
}
