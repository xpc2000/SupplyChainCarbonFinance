package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ReduceCore;
import com.example.chaincarbon.model.pojo.ReduceCoreExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ReduceCoreMapper {
    int deleteByPrimaryKey(String name);

    int insert(ReduceCore record);

    int insertSelective(ReduceCore record);

    List<ReduceCore> selectByExample(ReduceCoreExample example);

    ReduceCore selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") ReduceCore record, @Param("example") ReduceCoreExample example);

    int updateByExample(@Param("record") ReduceCore record, @Param("example") ReduceCoreExample example);

    int updateByPrimaryKeySelective(ReduceCore record);

    int updateByPrimaryKey(ReduceCore record);
}