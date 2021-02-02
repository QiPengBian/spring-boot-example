package com.example.item.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * 
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-19 16:50:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName("tb_order_item")
public class OrderItemEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	@TableField(value = "user_id")
	private Long userId;
	/**
	 * 
	 */
	@TableField(value = "order_id")
	private Long orderId;
	/**
	 * 
	 */
	@TableField(value = "order_item_id")
	private Long orderItemId;

	public static final String ID = "id";

	public static final String USER_ID = "user_id";

	public static final String ORDER_ID = "order_id";

	public static final String ORDER_ITEM_ID = "order_item_id";

}
