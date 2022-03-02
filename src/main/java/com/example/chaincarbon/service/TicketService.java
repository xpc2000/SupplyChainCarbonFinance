package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.FactorDao;
import com.example.chaincarbon.dao.TicketDao;
import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.pojo.TicketRecord;
import com.example.chaincarbon.model.vo.TicketVo;
import com.example.chaincarbon.model.vo.TransferTicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 碳信记录子模块
 */
@Service
public class TicketService {
    @Autowired
    TicketDao ticketDao;

    @Autowired
    FactorDao factorDao;

    public Boolean insertTicketRecord(TicketVo ticketVo, Integer type){
        int result;
        TicketRecord ticketRecord=new TicketRecord();
        ticketRecord.setStatus(0);
        ticketRecord.setInitiatorName(ticketVo.getSender());
        ticketRecord.setInitiatorSupplyChain(ticketVo.getSenderChain());
        ticketRecord.setReceiverName(ticketVo.getReceiver());
        ticketRecord.setReceiverSupplyChain(ticketVo.getReceiverChain());
        ticketRecord.setAmountCarbonTicket(ticketVo.getNum());
        ticketRecord.setOperation(type);
        ticketRecord.setFundUse(ticketVo.getUsage());
        ticketRecord.setOperationData(new Date());
        result=ticketDao.insertTicket(ticketRecord);
        return result!=-1;
    }

    public Boolean updateTicket(Integer id,Boolean comment){
        int result;
        if(comment) result=ticketDao.updateTicket(id,4);
        else result=ticketDao.updateTicket(id,3);
        return result!=-1;
    }

    public String ticketFactor(Integer id, String chain){
        int result;
        String financeName;
        FactorRecord record=factorDao.getFactor(id);
        if(record==null) return "null";
        financeName=record.getFactoringCompany();
        TicketRecord ticketRecord=new TicketRecord();
        ticketRecord.setAmountCarbonTicket(record.getAmountCarbonTicket());
        ticketRecord.setInitiatorSupplyChain(chain);
        ticketRecord.setReceiverSupplyChain("金融业");
        ticketRecord.setInitiatorName(record.getCompany());
        ticketRecord.setReceiverName(record.getFactoringCompany());
        ticketRecord.setOperation(5);
        ticketRecord.setStatus(4);
        ticketRecord.setFundUse(record.getFundUse());
        ticketRecord.setOperationData(new Date());
        result=ticketDao.insertTicket(ticketRecord);
        if(result==-1) financeName= "null";
        return financeName;
    }

    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业所属减排链，企业名称，状态，类型，操作类型
     * @Return:List<TicketRecord>
     * @Description:获取减排链企业碳信记录
     */
    public List<TransferTicketVo> getTicketRecords(String supplyChain, String company, Integer state, Integer type, List<Integer> operation){
        List<TransferTicketVo> out = new LinkedList<>();
        for(TicketRecord item: ticketDao.getTicketRecords(supplyChain,company,state,type,operation)){
            TransferTicketVo transferTicketVo = new TransferTicketVo();
            transferTicketVo.setId(item.getId());
            transferTicketVo.setType(item.getOperation());
            transferTicketVo.setAmount(item.getAmountCarbonTicket());
            transferTicketVo.setSender(item.getInitiatorName());
            transferTicketVo.setTime(item.getOperationData());
            out.add(transferTicketVo);
        }
        return out;
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:TicketRecord
     * @Description:获取碳信记录
     */
    public TicketRecord getTicketRecord(Integer id){
        return ticketDao.getTicketRecord(id);
    }
}
