package com.example.order.mapper;

import com.example.order.domain.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-19 16:52:53
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	
}
