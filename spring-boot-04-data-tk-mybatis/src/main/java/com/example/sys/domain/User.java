package com.example.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description: 用户信息表
 * @author: QiPeng
 * @date: 2021-02-05 16:01:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;

	public static final String ID = "id";

	public static final String DB_ID = "id";

	public static final String USERNAME = "username";

	public static final String DB_USERNAME = "username";

	public static final String PASSWORD = "password";

	public static final String DB_PASSWORD = "password";

}
