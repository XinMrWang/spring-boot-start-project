package com.halink.scaffold.config.enumhandler;

import com.halink.scaffold.common.enumerate.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author halink
 */
public class AutoConversionHandler <E extends Enum<E>> extends BaseTypeHandler<E> {

    private BaseTypeHandler typeHandler;

    @SuppressWarnings("unchecked")
    public AutoConversionHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        if(BaseEnum.class.isAssignableFrom(type)){
            // 如果实现了 BaseCodeEnum 则使用我们自定义的转换器
            typeHandler = new CodeEnumTypeHandler(type);
        }else {
            // 默认转换器 也可换成 EnumOrdinalTypeHandler
            typeHandler = new EnumTypeHandler<>(type);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        typeHandler.setNonNullParameter(ps,i, parameter,jdbcType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return (E) typeHandler.getNullableResult(rs,columnName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return (E) typeHandler.getNullableResult(rs,columnIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return (E) typeHandler.getNullableResult(cs,columnIndex);
    }
}
