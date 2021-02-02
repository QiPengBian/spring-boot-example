package com.example;

import com.example.item.domain.OrderItemEntity;
import com.example.item.service.OrderItemService;
import com.example.order.domain.OrderEntity;
import com.example.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot04DataDynamicApplicationTests {

    @Autowired
    private OrderItemService itemService;

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        List<OrderItemEntity> orderItemEntityList = itemService.list();
        List<OrderEntity> orderEntityList = orderService.list();
        orderItemEntityList.forEach(System.out::println);
        orderEntityList.forEach(System.out::println);
    }
}
