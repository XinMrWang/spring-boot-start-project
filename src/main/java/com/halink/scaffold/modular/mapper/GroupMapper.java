package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Group;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    int updateBatch(List<Group> list);

    int batchInsert(@Param("list") List<Group> list);
}