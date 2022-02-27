package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ReduceSub;
import com.example.chaincarbon.model.pojo.ReduceSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReduceSubMapper {
    int insert(ReduceSub record);

    int insertSelective(ReduceSub record);

    List<ReduceSub> selectByExample(ReduceSubExample example);

    int updateByExampleSelective(@Param("record") ReduceSub record, @Param("example") ReduceSubExample example);

    int updateByExample(@Param("record") ReduceSub record, @Param("example") ReduceSubExample example);
}