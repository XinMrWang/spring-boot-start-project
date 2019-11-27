package com.lsc.startproject.modular.mapper;

import com.lsc.startproject.common.entity.RolePermissionRelation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionRelationMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RolePermissionRelation record);

    int insertSelective(RolePermissionRelation record);

    RolePermissionRelation selectByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int updateByPrimaryKeySelective(RolePermissionRelation record);

    int updateByPrimaryKey(RolePermissionRelation record);

    int updateBatch(List<RolePermissionRelation> list);

    int batchInsert(@Param("list") List<RolePermissionRelation> list);
}