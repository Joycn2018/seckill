package com.chi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.seckill.entity.Product;

import java.math.BigDecimal;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
public interface ProductService extends IService<Product> {
    public boolean saveProduct(Product product);

    public BigDecimal calculatePrice(long productID, int quantity);
}
