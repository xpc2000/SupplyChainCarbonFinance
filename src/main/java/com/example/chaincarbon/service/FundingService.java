package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.FactorDao;
import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FundingService {
    @Autowired
    FactorDao factorDao;
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
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:FactorRecord
     * @Description:获取融资记录
     */
    public FactorRecord getFactorRecord(Integer id){
        return factorDao.getFactorRecord(id);
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:金融机构名称，状态
     * @Return:List<FactorRecord>
     * @Description:获取金融机构保理记录
     */
    public List<FactorForInstitutionVo> getInstitutionFactorRecords(String company, Integer state){
        List<FactorForInstitutionVo> out = new LinkedList<>();
        for(FactorRecord item:factorDao.getInstitutionFactorRecords(company,state)){
            FactorForInstitutionVo factorForInstitutionVo = new FactorForInstitutionVo();
            factorForInstitutionVo.setAmount(item.getAmountCarbonTicket());
            factorForInstitutionVo.setStatus(item.getStatus());
            factorForInstitutionVo.setId(item.getId());
            factorForInstitutionVo.setTime(item.getOperationTime());
            factorForInstitutionVo.setCompany(item.getCompany());
            out.add(factorForInstitutionVo);
        }
        return out;
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业名称，状态
     * @Return:List<FactorRecord>
     * @Description:获取企业保理记录
     */
    public List<FactorForCompanyVo> getCompanyFactorRecords(String company, Integer state){
        List<FactorForCompanyVo> out = new LinkedList<>();
        for(FactorRecord item:factorDao.getCompanyFactorRecords(company,state)){
            FactorForCompanyVo factorForCompanyVo = new FactorForCompanyVo();
            factorForCompanyVo.setAmount(item.getAmountCarbonTicket());
            factorForCompanyVo.setId(item.getId());
            factorForCompanyVo.setInstitution(item.getFactoringCompany());
            factorForCompanyVo.setTime(item.getOperationTime());
            factorForCompanyVo.setStatus(item.getStatus());
            out.add(factorForCompanyVo);
        }
        return out;
    }
}
