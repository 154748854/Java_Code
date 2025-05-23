package com.example.book.demos.web.enums;

import java.awt.print.Book;

public enum BookStatusEnum {
    DELETE(0,"删除"),
    NORMAL(1,"可借阅"),
    FORBIDDEN(2,"不可借阅");

    public static BookStatusEnum getNameByCode(int code) {
        switch(code) {
            case 0: return BookStatusEnum.DELETE;
            case 1: return BookStatusEnum.NORMAL;
            default: return BookStatusEnum.FORBIDDEN;
        }
    }
    BookStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
