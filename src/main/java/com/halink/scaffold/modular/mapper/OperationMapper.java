package com.halink.scaffold.modular.mapper;

import com.halink.scaffold.common.entity.Operation;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface OperationMapper {
    int deleteByPrimaryKey(Long operationId);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long operationId);

    int updateByPrimaryKeySelective(Operation record);

}