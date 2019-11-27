package com.lsc.startproject.modular.mapper;

import com.lsc.startproject.common.entity.Operation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationMapper {
    int deleteByPrimaryKey(Integer operationId);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Integer operationId);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);

    int updateBatch(List<Operation> list);

    int batchInsert(@Param("list") List<Operation> list);
}