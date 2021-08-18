package com.chi.seckill.controller;


import com.chi.seckill.entity.Product;
import com.chi.seckill.entity.Store;
import com.chi.seckill.entity.TOrder;
import com.chi.seckill.service.ProductService;
import com.chi.seckill.service.StoreService;
import com.chi.seckill.service.TOrderService;
import com.chi.seckill.service.impl.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/t-order")
public class TOrderController {

    @Autowired
    TOrderService tOrderService;

    @Autowired
    ProductService productService;

    @ApiOperation(value = "商品下单")
    @GetMapping("/submit")
    public R buy(@ApiParam(name = "customerID", value = "消费者id", required = true) @RequestParam("customerID") long customerID,
                 @ApiParam(name = "productID", value = "商品id", required = true) @RequestParam("productID") long productID,
                 @ApiParam(name = "quantity", value = "购买数量", required = true) @RequestParam("quantity") int quantity){

        tOrderService.submit(customerID, productID, quantity);
        // 1、获取订单总价
//        BigDecimal totalPrice = productService.calculatePrice(productID, quantity);

//        // 2、判断用户余额是否充足
//
//        TOrder order = new TOrder();
//        order.setCustomer(customerID);
//        order.setPrice(totalPrice);
//        order.setSales(quantity);
//        order.setProductId(productID);
        return R.ok();
    }

}

