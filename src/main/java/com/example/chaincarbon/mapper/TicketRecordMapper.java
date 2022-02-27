package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.TicketRecord;
import com.example.chaincarbon.model.pojo.TicketRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketRecord record);

    int insertSelective(TicketRecord record);

    List<TicketRecord> selectByExample(TicketRecordExample example);

    TicketRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketRecord record, @Param("example") TicketRecordExample example);

    int updateByExample(@Param("record") TicketRecord record, @Param("example") TicketRecordExample example);

    int updateByPrimaryKeySelective(TicketRecord record);

    int updateByPrimaryKey(TicketRecord record);
}