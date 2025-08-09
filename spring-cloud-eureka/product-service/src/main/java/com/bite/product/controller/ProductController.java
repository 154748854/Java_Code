package com.bite.product.controller;

import com.bite.product.model.ProductInfo;
import com.bite.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/{productId}")
    public ProductInfo getProductById(@PathVariable("productId") Integer productId){
        log.info("接收到参数: productId"+productId);
        return productService.selectProductById(productId);
    }
}
