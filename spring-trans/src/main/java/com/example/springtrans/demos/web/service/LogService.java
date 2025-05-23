package com.example.springtrans.demos.web.service;

import com.example.springtrans.demos.web.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insert(String userName, String op) {
        return logInfoMapper.insertLog(userName, op);
    }
}
