package com.example.sys.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-07-07 14:21:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName("sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	@TableField(value = "username")
	private String username;
	/**
	 * 密码
	 */
	@TableField(value = "password")
	private String password;
	/**
	 * 是否有效：0-无效，1-有效
	 */
	@TableField(value = "enabled")
	private Integer enabled;

	public static final String ID = "id";

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";

	public static final String ENABLED = "enabled";

}
