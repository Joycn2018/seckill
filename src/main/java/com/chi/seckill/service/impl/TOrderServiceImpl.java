package com.chi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chi.seckill.entity.Customer;
import com.chi.seckill.entity.Product;
import com.chi.seckill.entity.TOrder;
import com.chi.seckill.mapper.CustomerMapper;
import com.chi.seckill.mapper.ProductMapper;
import com.chi.seckill.mapper.TOrderMapper;
import com.chi.seckill.service.ProductService;
import com.chi.seckill.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    TOrderMapper orderMapper;

    @Override
    @Transactional
    public boolean submit(long customerID, long productID, int quantity) {
        // 1、判断商品是否存在
        boolean isExist = false;
        Product product = productMapper.selectById(productID);
        if (product == null){
            return false;
        }

        // 2、判断库存是否足够
        int inventory = product.getInventory() - quantity;
        if(inventory < 0)
            return false;

        // 3、计算账户余额是否充足
        Customer customer = customerMapper.selectById(customerID);
        BigDecimal totalPrice = product.getPerPrice().multiply(new BigDecimal(quantity));
        BigDecimal balance = customer.getBalance().subtract(totalPrice);
        int result = balance.compareTo(BigDecimal.ZERO);
        if (result < 0)
            return false;

        // 4、操作数据表：商品下单
        // 4.1 减余额
        customer.setBalance(balance);
        customerMapper.updateById(customer);
        // 4.2 减库存
        product.setInventory(product.getInventory() - quantity);
        productMapper.updateById(product);

        // 4.3 存储订单
        TOrder order = new TOrder();
        order.setCustomer(customerID);
        order.setProductId(productID);
        order.setSales(quantity);
        order.setPrice(totalPrice);
        orderMapper.insert(order);

        return true;
    }
}
