package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.TicketRecordMapper;
import com.example.chaincarbon.model.pojo.TicketRecord;
import com.example.chaincarbon.model.pojo.TicketRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {
    @Autowired
    TicketRecordMapper ticketRecordMapper;
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:TicketRecord
     * @Description:获取碳信记录
     */
    public TicketRecord getTicketRecord(Integer id){
        try {
            return ticketRecordMapper.selectByPrimaryKey(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业所属减排链，企业名称，状态，类型，操作类型
     * @Return:List<TicketRecord>
     * @Description:获取减排链企业碳信记录
     */
    public List<TicketRecord> getTicketRecords(String supplyChain, String company, Integer state, Integer type, List<Integer> operation){
        TicketRecordExample ticketRecordExample = new TicketRecordExample();
        TicketRecordExample.Criteria criteria = ticketRecordExample.createCriteria();
        if(state!=-1){
            criteria.andStatusEqualTo(state);
        }
        criteria.andOperationIn(operation);
        if(type==0){
            criteria.andReceiverSupplyChainEqualTo(supplyChain);
            criteria.andReceiverNameEqualTo(company);
        }
        else if(type==1){
            criteria.andInitiatorSupplyChainEqualTo(supplyChain);
            criteria.andInitiatorNameEqualTo(company);
        }
        else if(type==-1){
            TicketRecordExample.Criteria criteria2 = ticketRecordExample.createCriteria();
            criteria.andInitiatorSupplyChainEqualTo(supplyChain);
            criteria.andInitiatorNameEqualTo(company);
            criteria2.andReceiverSupplyChainEqualTo(supplyChain);
            criteria2.andReceiverNameEqualTo(company);
            ticketRecordExample.or(criteria2);
            if(state!=-1){
                criteria2.andStatusEqualTo(state);
            }
            criteria2.andOperationIn(operation);
        }
        try {
            return ticketRecordMapper.selectByExample(ticketRecordExample);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
