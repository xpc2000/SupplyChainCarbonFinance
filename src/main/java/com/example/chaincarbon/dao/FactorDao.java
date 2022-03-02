package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.FactorRecordMapper;
import com.example.chaincarbon.model.pojo.FactorRecord;
import com.example.chaincarbon.model.pojo.FactorRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 保理记录的CRUD
 */
@Repository
public class FactorDao {
    @Autowired
    FactorRecordMapper factorRecordMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: FactorRecord factorRecord
     * @Return: 执行结果
     * @Description: 插入保理记录
     */
    public int insertFactor(FactorRecord factorRecord){
        int result=0;
        try{
            result=factorRecordMapper.insertSelective(factorRecord);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return -1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer status, Integer id
     * @Return: 执行结果
     * @Description: 更新保理状态
     */
    public int updateStatus(Integer status, Integer id){
        int result=0;
        FactorRecordExample factorRecordExample=new FactorRecordExample();
        FactorRecordExample.Criteria criteria=factorRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        FactorRecord factorRecord=new FactorRecord();
        factorRecord.setStatus(status);
        try{
            result=factorRecordMapper.updateByExampleSelective(factorRecord,factorRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: FactorRecord factorRecord, Integer id,String finance, String company
     * @Return: 执行结果
     * @Description: 更新保理信息
     */
    public int updateInfo(FactorRecord factorRecord, Integer id,String finance, String company){
        int result=0;
        FactorRecordExample factorRecordExample=new FactorRecordExample();
        FactorRecordExample.Criteria criteria=factorRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andFactoringCompanyEqualTo(finance);
        criteria.andCompanyEqualTo(company);
        try{
            result=factorRecordMapper.updateByExampleSelective(factorRecord,factorRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer id
     * @Return: FactorRecord
     * @Description: 通过主键查找保理记录
     */
    public FactorRecord getFactor(Integer id){
        try{
            return factorRecordMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
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
