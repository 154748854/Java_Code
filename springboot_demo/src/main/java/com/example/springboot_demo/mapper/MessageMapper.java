package com.example.springboot_demo.mapper;

import com.example.springboot_demo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    @Insert("insert into message_info(`from`,`to`,`message`) values (#{from},#{to},#{message})")
    public void insertMessage(MessageInfo messageInfo);
}
