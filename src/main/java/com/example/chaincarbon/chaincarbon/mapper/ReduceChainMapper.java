package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ReduceChain;
import com.example.chaincarbon.model.pojo.ReduceChainExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ReduceChainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReduceChain record);

    int insertSelective(ReduceChain record);

    List<ReduceChain> selectByExample(ReduceChainExample example);

    ReduceChain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReduceChain record, @Param("example") ReduceChainExample example);

    int updateByExample(@Param("record") ReduceChain record, @Param("example") ReduceChainExample example);

    int updateByPrimaryKeySelective(ReduceChain record);

    int updateByPrimaryKey(ReduceChain record);
}