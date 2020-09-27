package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;import java.util.List;

public interface RolePermissionRelationMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RolePermissionRelation record);

    int insertSelective(RolePermissionRelation record);

    RolePermissionRelation selectByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int updateByPrimaryKeySelective(RolePermissionRelation record);

}