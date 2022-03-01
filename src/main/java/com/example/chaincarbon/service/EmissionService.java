package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.FinanceDao;
import com.example.chaincarbon.dao.PlanDao;
import com.example.chaincarbon.dao.PledgeDao;
import com.example.chaincarbon.model.pojo.PledgeRecord;
import com.example.chaincarbon.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmissionService {
    @Autowired
    PledgeDao pledgeDao;

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
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:PledgeRecord
     * @Description:获取碳质押记录
     */
    public PledgeRecord getPledgeRecord(Integer id){
        return pledgeDao.getPledgeRecord(id);
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:金融机构名称，状态
     * @Return:List<PledgeRecord>
     * @Description:获取金融机构碳质押记录
     */
    public List<PledgeForInstitutionVo> getInstitutionPledgeRecords(String company, Integer state) {
        List<PledgeForInstitutionVo> out = new LinkedList<>();
        for(PledgeRecord item:pledgeDao.getInstitutionPledgeRecords(company,state)){
            PledgeForInstitutionVo pledgeForInstitutionVo = new PledgeForInstitutionVo();
            pledgeForInstitutionVo.setAmount(item.getPledgeAmount());
            pledgeForInstitutionVo.setStatus(item.getStatus());
            pledgeForInstitutionVo.setId(item.getId());
            pledgeForInstitutionVo.setChain(item.getControlChain());
            pledgeForInstitutionVo.setOwner(item.getQuotaOwner());
            out.add(pledgeForInstitutionVo);
        }
        return out;
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业所属控排链，企业名称，状态
     * @Return:List<PledgeRecord>
     * @Description:获取控排链企业碳质押记录
     */
    public List<PledgeForCompanyVo> getCompanyPledgeRecords(String controlChain, String company, Integer state){
        List<PledgeForCompanyVo> out = new LinkedList<>();
        for(PledgeRecord item:pledgeDao.getCompanyPledgeRecords(controlChain,company,state)){
            PledgeForCompanyVo pledgeForCompanyVo = new PledgeForCompanyVo();
            pledgeForCompanyVo.setAmount(item.getQuotaQuantity());
            pledgeForCompanyVo.setId(item.getId());
            pledgeForCompanyVo.setStatus(item.getStatus());
            pledgeForCompanyVo.setInstitution(item.getCompany());
            out.add(pledgeForCompanyVo);
        }
        return out;
    }
}
