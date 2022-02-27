package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ControlCore;
import com.example.chaincarbon.model.pojo.ControlCoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ControlCoreMapper {
    int deleteByPrimaryKey(String name);

    int insert(ControlCore record);

    int insertSelective(ControlCore record);

    List<ControlCore> selectByExample(ControlCoreExample example);

    ControlCore selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") ControlCore record, @Param("example") ControlCoreExample example);

    int updateByExample(@Param("record") ControlCore record, @Param("example") ControlCoreExample example);

    int updateByPrimaryKeySelective(ControlCore record);

    int updateByPrimaryKey(ControlCore record);
}