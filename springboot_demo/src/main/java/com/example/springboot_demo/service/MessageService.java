package com.example.springboot_demo.service;

import com.example.springboot_demo.mapper.MessageMapper;
import com.example.springboot_demo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public void addMessage(MessageInfo messageInfo) {
        messageMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> getMessageInfo() {
        return messageMapper.selectAllMessage();
    }
}
