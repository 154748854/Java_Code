package com.example.book.demos.web.dao;

import com.example.book.demos.web.model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class BookDao {

    public List<BookInfo> mockData() {
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
