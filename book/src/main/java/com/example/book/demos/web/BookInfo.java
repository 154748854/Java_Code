package com.example.book.demos.web;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;// 1. 表示可借阅 2. 表示不可借阅
    private String statusCN;
}
