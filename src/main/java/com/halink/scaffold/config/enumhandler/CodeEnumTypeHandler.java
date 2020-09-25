package com.halink.scaffold.config.enumhandler;

import com.halink.scaffold.common.enumerate.BaseEnum;
import com.halink.scaffold.core.util.CodeEnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author halink
 */
public class CodeEnumTypeHandler<E extends Enum<?> & BaseEnum> extends BaseTypeHandler<BaseEnum> {

  private Class<E> type;

  public CodeEnumTypeHandler(Class<E> type) {
    if (type == null) {
      throw new IllegalArgumentException("Type argument cannot be null");
    }
    this.type = type;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType)
          throws SQLException {
    ps.setInt(i, parameter.getValue());
  }

  @Override
  public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
    int i = rs.getInt(columnName);
    if (rs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, i);
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    int i = rs.getInt(columnIndex);
    if (rs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, i);
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    int i = cs.getInt(columnIndex);
    if (cs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, i);
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }
}
