package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.Plan;
import com.example.chaincarbon.model.pojo.PlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    int insertSelective(Plan record);

    List<Plan> selectByExample(PlanExample example);

    Plan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);
}