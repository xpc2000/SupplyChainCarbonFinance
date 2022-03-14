package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.FactorDao;
import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.vo.*;
import com.example.chaincarbon.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 碳信融资子模块
 */
@Service
public class FundingService {

    @Autowired
    FactorDao factorDao;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: ApplyFactorVo applyFactorVo
     * @Return: Boolean
     * @Description: 碳信保理申请的业务逻辑实现
     */
    public Boolean apply(ApplyFactorVo applyFactorVo){
        FactorRecord factorRecord=new FactorRecord();
        factorRecord.setCompany(applyFactorVo.getCompanyNeedFund());
        factorRecord.setFactoringCompany(applyFactorVo.getCompanyOfferFund());
        factorRecord.setAmountCarbonTicket(applyFactorVo.getNum());
        factorRecord.setFundUse(applyFactorVo.getUsage());
        factorRecord.setBank(applyFactorVo.getBank());
        factorRecord.setAccount(applyFactorVo.getBankAccount());
        factorRecord.setOperationTime(new Date());
        factorRecord.setStatus(0);
        int result=factorDao.insertFactor(factorRecord);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: Boolean comment, Integer id
     * @Return: Boolean
     * @Description: 碳信保理合规审查的业务逻辑实现
     */
    public Boolean examine(Boolean comment, Integer id){
        int result;
        if (comment) result=factorDao.updateStatus(1,id);
        else result=factorDao.updateStatus(4,id);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: FactorVo factorVo
     * @Return: Boolean
     * @Description: 金融机构保理签约的业务逻辑实现
     */
    public Boolean financeFactor(FactorVo factorVo){
        int result;
        FactorRecord factorRecord=new FactorRecord();
        factorRecord.setFinancingAmount(factorVo.getFund());
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= null;
        try {
            date = fmt.parse(factorVo.getFactorDDL());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        factorRecord.setFinancingTerm(date);
        factorRecord.setOperationTime(new Date());
        factorRecord.setServiceRate(factorVo.getServiceRate());
        factorRecord.setInterestRate(factorVo.getInterestRate());
        factorRecord.setStatus(2);
        result=factorDao.updateInfo(factorRecord,factorVo.getID(),factorVo.getCompanyOfferFund(),factorVo.getCompanyNeedFund());
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: Boolean comment, Integer id
     * @Return: Boolean
     * @Description: 融资企业保理签约的业务逻辑实现
     */
    public Boolean companyFactor(Boolean comment, Integer id){
        int result;
        if (comment) result=factorDao.updateStatus(1,id);
        else result=factorDao.updateStatus(4,id);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: Integer id
     * @Return: FactorRecord
     * @Description: 获取特定保理记录
     */
    public FactorRecord getFactorRecord(Integer id){
        FactorRecord factorRecord=factorDao.getFactor(id);
        if(factorRecord.getOperationTime()!=null)
            factorRecord.setOperationTime(DateUtil.parseTime(factorRecord.getOperationTime()));
        if(factorRecord.getFinancingTerm()!=null)
            factorRecord.setFinancingTerm(DateUtil.parseTime(factorRecord.getFinancingTerm()));
        return factorRecord;
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
//            if (item.getOperationTime()!=null)
//                factorForInstitutionVo.setTime(DateUtil.parseTime(item.getOperationTime()));
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
//            if (item.getOperationTime()!=null)
//                factorForCompanyVo.setTime(DateUtil.parseTime(item.getOperationTime()));
            factorForCompanyVo.setStatus(item.getStatus());
            out.add(factorForCompanyVo);
        }
        return out;
    }
}
