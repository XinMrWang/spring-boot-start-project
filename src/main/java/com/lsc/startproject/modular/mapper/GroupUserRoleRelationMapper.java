package com.lsc.startproject.modular.mapper;

import com.lsc.startproject.common.entity.GroupUserRoleRelation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupUserRoleRelationMapper {
    int deleteByPrimaryKey(@Param("groupId") String groupId, @Param("userId") String userId, @Param("roleId") String roleId);

    int insert(GroupUserRoleRelation record);

    int insertSelective(GroupUserRoleRelation record);

    GroupUserRoleRelation selectByPrimaryKey(@Param("groupId") String groupId, @Param("userId") String userId, @Param("roleId") String roleId);

    int updateByPrimaryKeySelective(GroupUserRoleRelation record);

    int updateByPrimaryKey(GroupUserRoleRelation record);

    int updateBatch(List<GroupUserRoleRelation> list);

    int batchInsert(@Param("list") List<GroupUserRoleRelation> list);
}