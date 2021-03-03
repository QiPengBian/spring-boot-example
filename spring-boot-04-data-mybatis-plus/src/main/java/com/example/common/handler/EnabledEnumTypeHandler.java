package com.example.common.handler;

import com.example.common.enums.EnableEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-03-03 15:30:02
 */
public class EnabledEnumTypeHandler implements TypeHandler<EnableEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, EnableEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public EnableEnum getResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return EnableEnum.getEnumByKey(code);
    }

    @Override
    public EnableEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return EnableEnum.getEnumByKey(code);
    }

    @Override
    public EnableEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return EnableEnum.getEnumByKey(code);
    }
}
