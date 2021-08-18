package com.chi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chi.seckill.entity.Customer;
import com.chi.seckill.mapper.CustomerMapper;
import com.chi.seckill.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
