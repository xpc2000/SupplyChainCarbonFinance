package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.TicketDao;
import com.example.chaincarbon.model.pojo.TicketRecord;
import com.example.chaincarbon.model.vo.TransferTicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketDao ticketDao;
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
