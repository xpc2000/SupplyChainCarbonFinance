package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.PledgeDao;
import com.example.chaincarbon.model.pojo.PledgeRecord;
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
 * @Description: 碳质押记录子模块
 */
@Service
public class EmissionService {
    @Autowired
    PledgeDao pledgeDao;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: ApplyPledgeVo applyPledgeVo
     * @Return: Boolean
     * @Description: 碳配额质押申请的业务逻辑实现
     */
    public Boolean apply(ApplyPledgeVo applyPledgeVo){
        //插入碳质押记录
        PledgeRecord pledgeRecord=new PledgeRecord();
        pledgeRecord.setControlChain(applyPledgeVo.getChain());
        pledgeRecord.setQuotaOwner(applyPledgeVo.getCompanyNeedFund());
        pledgeRecord.setCompany(applyPledgeVo.getCompanyOfferFund());
        pledgeRecord.setFundUse(applyPledgeVo.getUsage());
        pledgeRecord.setQuotaQuantity(applyPledgeVo.getPledgeNum());
        pledgeRecord.setStatus(0);
        int result=pledgeDao.insertPledge(pledgeRecord);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: Boolean comment, Integer id
     * @Return: Boolean
     * @Description: 碳配额质押审查的业务逻辑实现
     */
    public Boolean examine(Boolean comment, Integer id){
        //修改碳质押记录的状态
        int result;
        if(comment) result=pledgeDao.updateStatus(1,id);
        else result=pledgeDao.updateStatus(4,id);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: PledgeVo pledgeVo
     * @Return: Boolean
     * @Description: 金融机构质押签约的业务逻辑实现
     */
    public Boolean financePledge(PledgeVo pledgeVo){
        //修改碳质押记录的状态和部分字段
        int result;
        PledgeRecord pledgeRecord=new PledgeRecord();
        pledgeRecord.setOperationData(new Date());
        pledgeRecord.setPledgeAmount(pledgeVo.getPledgeFund());
        pledgeRecord.setLoanInterestRate(pledgeVo.getInterestRate());
        pledgeRecord.setPledgeRate(pledgeVo.getPledgeRate());
        pledgeRecord.setStatus(2);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= null;
        try {
            date = fmt.parse(pledgeVo.getPledgeDDL());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        pledgeRecord.setLoanTerm(date);
        result=pledgeDao.updateInfo(pledgeRecord,pledgeVo.getID(),pledgeVo.getCompanyOfferFund(),pledgeVo.getCompanyNeedFund());
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: Boolean comment, Integer id
     * @Return: Boolean
     * @Description: 融资企业碳质押签约的业务逻辑实现
     */
    public Boolean companyPledge(Boolean comment, Integer id){
        //修改碳质押记录的状态
        int result;
        if(comment) result=pledgeDao.updateStatus(3,id);
        else result=pledgeDao.updateStatus(4,id);
        return result!=-1;
    }

    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:PledgeRecord
     * @Description:获取碳质押记录
     */
    public PledgeRecord getPledgeRecord(Integer id){
        PledgeRecord pledgeRecord=pledgeDao.getPledge(id);
        if(pledgeRecord.getOperationData()!=null)
            pledgeRecord.setOperationData(DateUtil.parseTime(pledgeRecord.getOperationData()));
        if(pledgeRecord.getLoanTerm()!=null)
            pledgeRecord.setLoanTerm(DateUtil.parseTime(pledgeRecord.getLoanTerm()));
        return pledgeRecord;
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
            pledgeForInstitutionVo.setAmount(item.getQuotaQuantity());
            pledgeForInstitutionVo.setStatus(item.getStatus());
            pledgeForInstitutionVo.setId(item.getId());
            pledgeForInstitutionVo.setChain(item.getControlChain());
            pledgeForInstitutionVo.setOwner(item.getQuotaOwner());
//            pledgeForInstitutionVo.setTime(item.getOperationData());
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
