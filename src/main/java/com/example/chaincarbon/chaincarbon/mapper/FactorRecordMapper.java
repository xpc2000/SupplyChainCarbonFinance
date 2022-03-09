package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.pojo.FactorRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FactorRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FactorRecord record);

    int insertSelective(FactorRecord record);

    List<FactorRecord> selectByExample(FactorRecordExample example);

    FactorRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactorRecord record, @Param("example") FactorRecordExample example);

    int updateByExample(@Param("record") FactorRecord record, @Param("example") FactorRecordExample example);

    int updateByPrimaryKeySelective(FactorRecord record);

    int updateByPrimaryKey(FactorRecord record);
}