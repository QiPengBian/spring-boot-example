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
 * @description: 角色信息表
 * @author: QiPeng
 * @date: 2021-02-05 13:52:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	public static final String ID = "id";

	public static final String DB_ID = "id";

	public static final String ROLE_NAME = "roleName";

	public static final String DB_ROLE_NAME = "role_name";

}
