package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Permission;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

}