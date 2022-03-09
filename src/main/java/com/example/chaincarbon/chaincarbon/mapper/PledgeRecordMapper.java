package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.PledgeRecord;
import com.example.chaincarbon.model.pojo.PledgeRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PledgeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PledgeRecord record);

    int insertSelective(PledgeRecord record);

    List<PledgeRecord> selectByExample(PledgeRecordExample example);

    PledgeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PledgeRecord record, @Param("example") PledgeRecordExample example);

    int updateByExample(@Param("record") PledgeRecord record, @Param("example") PledgeRecordExample example);

    int updateByPrimaryKeySelective(PledgeRecord record);

    int updateByPrimaryKey(PledgeRecord record);
}