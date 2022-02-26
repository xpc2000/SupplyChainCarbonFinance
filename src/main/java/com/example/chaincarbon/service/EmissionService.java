package com.example.chaincarbon.service;

import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyPledgeVo;
import com.example.chaincarbon.model.vo.PledgeVo;
import org.springframework.stereotype.Service;

@Service
public class EmissionService {

    public Boolean apply(ApplyPledgeVo applyPledgeVo){
        //插入碳质押记录
        return false;
    }

    public Boolean examine(ActionVo actionVo){
        //修改碳质押记录的状态
        return false;
    }

    public Boolean financePledge(PledgeVo pledgeVo){
        //修改碳质押记录的状态和部分字段
        return false;
    }

    public Boolean companyPledge(ActionVo actionVo){
        //修改碳质押记录的状态
        return false;
    }
}
