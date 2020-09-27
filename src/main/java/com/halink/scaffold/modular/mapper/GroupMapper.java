package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Group;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Group record);
}