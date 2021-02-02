package com.example.item.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.item.mapper.OrderItemMapper;
import com.example.item.domain.OrderItemEntity;
import com.example.item.service.OrderItemService;

/**
 * 
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-19 16:50:37
 */
@Service
@DS("item")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

}