package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    int updateBatch(List<Permission> list);

    int batchInsert(@Param("list") List<Permission> list);
}