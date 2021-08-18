package com.chi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chi.seckill.entity.Product;
import com.chi.seckill.entity.Store;
import com.chi.seckill.mapper.ProductMapper;
import com.chi.seckill.mapper.StoreMapper;
import com.chi.seckill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public BigDecimal calculatePrice(long productID, int quantity) {
        Product product = productMapper.selectById(productID);
        BigDecimal totalPrice = product.getPerPrice().multiply(new BigDecimal(quantity));
        return totalPrice;
    }

    @Override
    public boolean saveProduct(Product product) {

        long id = product.getStoreId();
        List<Store> stores = storeMapper.selectList(null);

        for (Store store : stores) {
            if(store.getId().equals(id)){
                productMapper.insert(product);
                return true;
            }
        }

        return false;
    }

}
