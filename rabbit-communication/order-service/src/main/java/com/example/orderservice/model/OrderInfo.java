package com.example.orderservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfo implements Serializable {
    private String orderId;
    private String name;
}
