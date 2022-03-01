package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.PledgeRecordMapper;
import com.example.chaincarbon.model.pojo.PledgeRecord;
import com.example.chaincarbon.model.pojo.PledgeRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PledgeDao {
    @Autowired
    PledgeRecordMapper pledgeRecordMapper;
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:PledgeRecord
     * @Description:获取碳质押记录
     */
    public PledgeRecord getPledgeRecord(Integer id){
        try {
            return pledgeRecordMapper.selectByPrimaryKey(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:金融机构名称，状态
     * @Return:List<PledgeRecord>
     * @Description:获取金融机构碳质押记录
     */
    public List<PledgeRecord> getInstitutionPledgeRecords(String company, Integer state){
        PledgeRecordExample pledgeRecordExample = new PledgeRecordExample();
        PledgeRecordExample.Criteria criteria = pledgeRecordExample.createCriteria();
        criteria.andCompanyEqualTo(company);
        if(state!=-1){
            criteria.andStatusEqualTo(state);
        }
        try{
            return pledgeRecordMapper.selectByExample(pledgeRecordExample);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业所属控排链，企业名称，状态
     * @Return:List<PledgeRecord>
     * @Description:获取控排链企业碳质押记录
     */
    public List<PledgeRecord> getCompanyPledgeRecords(String controlChain, String company, Integer state){
        PledgeRecordExample pledgeRecordExample = new PledgeRecordExample();
        PledgeRecordExample.Criteria criteria = pledgeRecordExample.createCriteria();
        criteria.andControlChainEqualTo(controlChain);
        criteria.andQuotaOwnerEqualTo(company);
        if(state!=-1){
            criteria.andStatusEqualTo(state);
        }
        try {
            return pledgeRecordMapper.selectByExample(pledgeRecordExample);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
