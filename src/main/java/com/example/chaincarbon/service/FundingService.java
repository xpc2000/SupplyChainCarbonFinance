package com.example.chaincarbon.service;

import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyFactorVo;
import com.example.chaincarbon.model.vo.FactorVo;
import org.springframework.stereotype.Service;

@Service
public class FundingService {
    public Boolean apply(ApplyFactorVo applyFactorVo){
        return false;
    }

    public Boolean examine(ActionVo actionVo){
        return false;
    }

    public Boolean financeFactor(FactorVo factorVo){
        return false;
    }

    public Boolean companyFactor(ActionVo actionVo){
        return false;
    }
}
