package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Role;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

}