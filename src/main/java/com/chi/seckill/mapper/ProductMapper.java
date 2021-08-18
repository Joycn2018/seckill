package com.chi.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chi.seckill.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
