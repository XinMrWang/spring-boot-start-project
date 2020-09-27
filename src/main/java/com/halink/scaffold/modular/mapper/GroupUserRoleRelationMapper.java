package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.GroupUserRoleRelation;
import org.apache.ibatis.annotations.Param;import java.util.List;

public interface GroupUserRoleRelationMapper {
    int deleteByPrimaryKey(@Param("groupId") Long groupId, @Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(GroupUserRoleRelation record);

    int insertSelective(GroupUserRoleRelation record);

    GroupUserRoleRelation selectByPrimaryKey(@Param("groupId") Long groupId, @Param("userId") Long userId, @Param("roleId") Long roleId);

    int updateByPrimaryKeySelective(GroupUserRoleRelation record);

}