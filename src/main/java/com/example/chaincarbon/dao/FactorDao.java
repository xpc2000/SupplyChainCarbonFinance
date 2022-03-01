package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.FactorRecordMapper;
import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.pojo.FactorRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FactorDao {
    @Autowired
    FactorRecordMapper factorRecordMapper;
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:记录id
     * @Return:FactorRecord
     * @Description:获取融资记录
     */
    public FactorRecord getFactorRecord(Integer id){
        try {
            return factorRecordMapper.selectByPrimaryKey(id);
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
     * @Return:List<FactorRecord>
     * @Description:获取金融机构保理记录
     */
    public List<FactorRecord> getInstitutionFactorRecords(String company, Integer state){
        FactorRecordExample factorRecordExample = new FactorRecordExample();
        FactorRecordExample.Criteria criteria = factorRecordExample.createCriteria();
        criteria.andFactoringCompanyEqualTo(company);
        if(state!=-1){
            criteria.andStatusEqualTo(state);
        }
        try{
            return factorRecordMapper.selectByExample(factorRecordExample);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @Author:周文峰
     * @Date:2022/2/28
     * @Param:企业名称，状态
     * @Return:List<FactorRecord>
     * @Description:获取企业保理记录
     */
    public List<FactorRecord> getCompanyFactorRecords(String company, Integer state){
        FactorRecordExample factorRecordExample = new FactorRecordExample();
        FactorRecordExample.Criteria criteria = factorRecordExample.createCriteria();
        criteria.andCompanyEqualTo(company);
        if(state!=-1){
            criteria.andStatusEqualTo(state);
        }
        try {
            return factorRecordMapper.selectByExample(factorRecordExample);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
