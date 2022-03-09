package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.TicketRecordMapper;
import com.example.chaincarbon.model.pojo.TicketRecord;
import com.example.chaincarbon.model.pojo.TicketRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 碳信转账记录的CRUD
 */
@Repository
public class TicketDao {
    @Autowired
    TicketRecordMapper ticketRecordMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: TicketRecord ticketRecord
     * @Return: 执行结果
     * @Description: 插入碳信记录
     */
    public int insertTicket(TicketRecord ticketRecord){
        int result=0;
        try{
            result=ticketRecordMapper.insertSelective(ticketRecord);
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer id, Integer status
     * @Return: 执行结果
     * @Description: 更新碳信状态
     */
    public int updateTicket(Integer id, Integer status){
        int result=0;
        TicketRecordExample ticketRecordExample=new TicketRecordExample();
        TicketRecordExample.Criteria criteria=ticketRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        TicketRecord ticketRecord=new TicketRecord();
        ticketRecord.setStatus(status);
        try{
            result=ticketRecordMapper.updateByExampleSelective(ticketRecord,ticketRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }
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
