package com.chi.seckill.controller;


import com.chi.seckill.entity.Customer;
import com.chi.seckill.service.CustomerService;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @ApiOperation(value = "添加用户")
    @GetMapping("/add")
    public R add(@ApiParam(name = "name", value = "用户昵称", required = true) @RequestParam("name") String name,
                 @ApiParam(name = "balance", value = "账户余额", required = true) @RequestParam("balance") BigDecimal balance){

        Customer customer = new Customer();
        customer.setName(name);
        customer.setBalance(balance);

        boolean save = service.save(customer);
        if (save){
            return R.ok().data("items",customer);
        }else{
            return R.error();
        }

    }

}

