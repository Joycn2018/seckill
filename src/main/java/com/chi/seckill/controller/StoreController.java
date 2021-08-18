package com.chi.seckill.controller;


import com.chi.seckill.entity.Store;
import com.chi.seckill.service.StoreService;
import com.chi.seckill.service.impl.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商家表 前端控制器
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService service;

    @ApiOperation(value = "添加商家")
    @GetMapping("/add")
    public R add(@ApiParam(name = "name", value = "商家昵称", required = true) @RequestParam("name") String name){
        Store store = new Store();
        store.setName(name); // id、create_time、update_time自动回填

        boolean save = service.save(store);
        if (save){
            return R.ok().data("items", store);
        }else{
            return R.error();
        }
    }

}

