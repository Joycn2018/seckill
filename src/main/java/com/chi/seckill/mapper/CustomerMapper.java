package com.chi.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chi.seckill.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
