package com.example.sys.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName("sys_role")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId
    private Long id;
    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;

    public static final String ID = "id";

    public static final String ROLE_NAME = "role_name";

}
