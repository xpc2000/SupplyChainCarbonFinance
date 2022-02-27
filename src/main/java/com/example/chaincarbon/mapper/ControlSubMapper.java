package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ControlSub;
import com.example.chaincarbon.model.pojo.ControlSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ControlSubMapper {
    int deleteByPrimaryKey(String name);

    int insert(ControlSub record);

    int insertSelective(ControlSub record);

    List<ControlSub> selectByExample(ControlSubExample example);

    ControlSub selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") ControlSub record, @Param("example") ControlSubExample example);

    int updateByExample(@Param("record") ControlSub record, @Param("example") ControlSubExample example);

    int updateByPrimaryKeySelective(ControlSub record);

    int updateByPrimaryKey(ControlSub record);
}