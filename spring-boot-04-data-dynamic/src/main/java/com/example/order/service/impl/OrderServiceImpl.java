package com.example.order.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.order.mapper.OrderMapper;
import com.example.order.domain.OrderEntity;
import com.example.order.service.OrderService;

/**
 * 
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-19 16:52:53
 */
@Service
@DS("order")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

}