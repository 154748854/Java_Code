package com.example.book.demos.web.service;

import com.example.book.demos.web.enums.BookStatusEnum;
import com.example.book.demos.web.mapper.BookInfoMapper;
import com.example.book.demos.web.model.BookInfo;
import com.example.book.demos.web.model.PageRequest;
import com.example.book.demos.web.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

        if (bookInfos!=null && bookInfos.size()>0) {
            for (BookInfo bookInfo:bookInfos) {
                // 根据status 获取状态的定义
                bookInfo.setStatusCN(BookStatusEnum.getNameByCode(bookInfo.getStatus()).getName());
            }
        }
        return new PageResult<>(bookInfos,count,pageRequest);
    }

    /**
     * 添加图书
     * @param bookInfo
     * @return
     */
    public Integer addBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.insertBook(bookInfo);
        }catch (Exception e) {
            log.error("添加图书出错,e:{}",e);
        }
        return result;
    }

    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.queryBookInfoById(id);
    }

    /**
     * 更新图示
     * @param bookInfo
     * @return
     */
    public Integer updateBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.updateBook(bookInfo);
        }catch (Exception e) {
            log.error("更新图示失败,e:{}",e);
        }
        return result;
    }

    public Integer batchDelete(List<Integer> ids) {
        Integer result = 0;
        try {
            result = bookInfoMapper.batchDelete(ids);
        }catch (Exception e) {
            log.error("批量删除失败,ids:{}",ids);
        }
        return result;
    }
}
