package com.example.chaincarbon.dao;


import com.example.chaincarbon.mapper.PledgeRecordMapper;
import com.example.chaincarbon.model.pojo.PledgeRecord;
import com.example.chaincarbon.model.pojo.PledgeRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 质押记录的CRUD
 */
@Repository
public class PledgeDao {
    @Autowired
    PledgeRecordMapper pledgeRecordMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: PledgeRecord pledgeRecord
     * @Return: 执行结果
     * @Description: 插入质押记录
     */
    public int insertPledge(PledgeRecord pledgeRecord){
        int result=0;
        try{
            result=pledgeRecordMapper.insertSelective(pledgeRecord);
        } catch (Exception e) {
            result=-1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer status, Integer id
     * @Return: 执行结果
     * @Description: 更新质押记录状态
     */
    public int updateStatus(Integer status, Integer id){
        int result=0;
        PledgeRecordExample pledgeRecordExample=new PledgeRecordExample();
        PledgeRecordExample.Criteria criteria=pledgeRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        PledgeRecord pledgeRecord=new PledgeRecord();
        pledgeRecord.setStatus(status);
        try{
            result=pledgeRecordMapper.updateByExampleSelective(pledgeRecord,pledgeRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: PledgeRecord pledgeRecord, Integer id,String finance, String company
     * @Return: 执行结果
     * @Description: 更新质押记录信息
     */
    public int updateInfo(PledgeRecord pledgeRecord, Integer id,String finance, String company){
        int result=0;
        PledgeRecordExample pledgeRecordExample=new PledgeRecordExample();
        PledgeRecordExample.Criteria criteria=pledgeRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andCompanyEqualTo(finance);
        criteria.andQuotaOwnerEqualTo(company);
        try{
            result=pledgeRecordMapper.updateByExampleSelective(pledgeRecord,pledgeRecordExample);
        } catch (Exception e) {
            result=-1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer id
     * @Return: PledgeRecord
     * @Description: 通过主键获取碳质押记录
     */
    public PledgeRecord getPledge(Integer id){
        try{
            return pledgeRecordMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<PledgeRecord> getPledgeList(Integer state,String finance){
//        PledgeRecordExample pledgeRecordExample=new PledgeRecordExample();
//        PledgeRecordExample.Criteria criteria=pledgeRecordExample.createCriteria();
//        criteria.andCompanyEqualTo(finance);
//        criteria.andStatusEqualTo(state);
//        try{
//            return pledgeRecordMapper.selectByExample(pledgeRecordExample);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
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
