package com.demo.order.service;

import com.demo.order.mapper.OrderMapper;
import com.demo.order.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public OrderInfo selectOrderById(Integer orderId) {
        return orderMapper.selectOrderById(orderId);
    }
}
