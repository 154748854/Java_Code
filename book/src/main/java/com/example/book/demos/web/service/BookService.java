package com.example.book.demos.web.service;

import com.example.book.demos.web.mapper.BookInfoMapper;
import com.example.book.demos.web.model.BookInfo;
import com.example.book.demos.web.model.PageRequest;
import com.example.book.demos.web.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 这个注解告诉Spring帮我们存一个对象
public class BookService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest) {
        if (pageRequest == null) {
            return null;
        }
        // 获取总信息数
        Integer count = bookInfoMapper.count();

        // 获取当前记录数
        List<BookInfo> bookInfos = bookInfoMapper.selectUserByPage(pageRequest.getOffset(), pageRequest.getPageSize());
        return new PageResult<>(bookInfos,count,pageRequest);
    }

}
