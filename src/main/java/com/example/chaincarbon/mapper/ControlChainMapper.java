package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.ControlChain;
import com.example.chaincarbon.model.pojo.ControlChainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ControlChainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ControlChain record);

    int insertSelective(ControlChain record);

    List<ControlChain> selectByExample(ControlChainExample example);

    ControlChain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ControlChain record, @Param("example") ControlChainExample example);

    int updateByExample(@Param("record") ControlChain record, @Param("example") ControlChainExample example);

    int updateByPrimaryKeySelective(ControlChain record);

    int updateByPrimaryKey(ControlChain record);
}