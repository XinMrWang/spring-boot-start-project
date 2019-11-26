package com.lsc.startproject.config.enumhandler;

import com.lsc.startproject.common.enumerate.BaseEnum;
import com.lsc.startproject.core.util.CodeEnumUtil;
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

  CodeEnumTypeHandler(Class<E> type) {
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
    if (rs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, rs.getInt(columnName));
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + rs.getInt(columnName) + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    if (rs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, rs.getInt(columnIndex));
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + rs.getInt(columnIndex) + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    if (cs.wasNull()) {
      return null;
    } else {
      try {
        return CodeEnumUtil.codeOf(type, cs.getInt(columnIndex));
      } catch (Exception ex) {
        throw new IllegalArgumentException("Cannot convert " + cs.getInt(columnIndex) + " to " + type.getSimpleName() + " by ordinal value.",
                ex);
      }
    }
  }
}
