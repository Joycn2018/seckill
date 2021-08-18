package com.chi.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chi.seckill.entity.Store;
import com.chi.seckill.mapper.StoreMapper;
import com.chi.seckill.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家表 服务实现类
 * </p>
 *
 * @author ChiYuhang
 * @since 2021-08-13
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

}
