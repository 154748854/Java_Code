package com.example.springboot_demo.controller;

import com.example.springboot_demo.model.MessageInfo;
import com.example.springboot_demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/message")
@RestController
public class MessageController {
    // 这个对象是在内存中的,所以它的数据也是在内存中的
    // private List<MessageInfo> messageInfos = new ArrayList<>();

    @Autowired
    private MessageService messageService;

    @RequestMapping("/publish")
   public Boolean publishMessage(MessageInfo messageInfo) {
        // 进行参数的判断
        if (!StringUtils.hasLength(messageInfo.getMessage())
        || !StringUtils.hasLength(messageInfo.getTo())
        || !StringUtils.hasLength(messageInfo.getFrom())) {
            return false;
        }

        // 添加留言
        messageService.addMessage(messageInfo);
        return true;

   }

   @RequestMapping("/getMessageInfo")
   public List<MessageInfo> getMessageInfo() {
        return messageService.getMessageInfo();
   }
}
