package com.chi.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.seckill.entity.TOrder;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
public interface TOrderService extends IService<TOrder> {

    /**
     * 提交订单
     * @param customerID 消费者id
     * @param productID 商品id
     * @param quantity  购买数量
     * @return  true：下单成功、false：下单失败
     */
    boolean submit(long customerID, long productID, int quantity);
}
