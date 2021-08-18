package com.chi.seckill.controller;


import com.chi.seckill.entity.Customer;
import com.chi.seckill.entity.Product;
import com.chi.seckill.service.CustomerService;
import com.chi.seckill.service.ProductService;
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
 * 商品表 前端控制器
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @ApiOperation(value = "添加商品")
    @GetMapping("/add")
    public R add(@ApiParam(name = "storeID", value = "商家id", required = true) @RequestParam("storeID") long storeID,
                 @ApiParam(name = "perPrice", value = "商品单价", required = true) @RequestParam("perPrice") BigDecimal perPrice,
                 @ApiParam(name = "inventory", value = "商品库存", required = true) @RequestParam("inventory") int inventory,
                 @ApiParam(name = "name", value = "商品名称", required = true) @RequestParam("name") String name,
                 @ApiParam(name = "detail", value = "商品描述", required = true) @RequestParam("detail") String detail){

        Product product = new Product();
        product.setStoreId(storeID);
        product.setPerPrice(perPrice);
        product.setInventory(inventory);
        product.setName(name);
        product.setDetail(detail);
        boolean save = service.saveProduct(product);
        if (save){
            return R.ok().data("items",product);
        }else{
            return R.error();
        }

    }


}

