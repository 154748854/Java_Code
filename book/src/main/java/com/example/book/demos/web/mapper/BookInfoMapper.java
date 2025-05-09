package com.example.book.demos.web.mapper;

import com.example.book.demos.web.model.BookInfo;
import com.example.book.demos.web.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    /**
     * 获取当前页信息
     * @param offset
     * @param passSize
     * @return
     */
    @Select("select * from user_info order by id desc where status !=0 " +
            "limit #{offset}, #{pageSize}")
    List<BookInfo> selectUserByPage(Integer offset, Integer passSize);

    /**
     * 获取总记录数
     * @return
     */
    @Select("select count(1) from book_info where status !=0")
    Integer count();

    @Insert("insert into book_info (book_name, author, count, price, publish, status) " +
            "values(#{bookName}, #{author}, {count}, #{price}, #{publish}, #{status})")
    Integer insertBook(BookInfo bookInfo);


    @Select("select * from book_info where id = #{id}")
    BookInfo queryBookInfoById(Integer id);


    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(List<Integer> ids);
}
