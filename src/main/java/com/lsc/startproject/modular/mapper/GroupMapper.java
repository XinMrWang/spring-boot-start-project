package com.lsc.startproject.modular.mapper;

import com.lsc.startproject.common.entity.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(String groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(String groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    int updateBatch(List<Group> list);

    int batchInsert(@Param("list") List<Group> list);
}