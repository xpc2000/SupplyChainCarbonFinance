package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.FinanceInstitutionMapper;
import com.example.chaincarbon.model.pojo.FinanceInstitution;
import com.example.chaincarbon.model.pojo.FinanceInstitutionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 金融机构的CRUD
 */
@Repository
public class FinanceDao {
    @Autowired
    FinanceInstitutionMapper financeInstitutionMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: FinanceInstitution
     * @Description: 通过主键寻找金融机构
     */
    public FinanceInstitution getFinance(String name){
        try{
            return financeInstitutionMapper.selectByPrimaryKey(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String email
     * @Return: FinanceInstitution
     * @Description: 通过邮箱寻找金融机构
     */
    public FinanceInstitution getFinanceByEmail(String email){
        FinanceInstitutionExample financeInstitutionExample=new FinanceInstitutionExample();
        FinanceInstitutionExample.Criteria criteria=financeInstitutionExample.createCriteria();
        criteria.andEmailEqualTo(email);
        try{
            List<FinanceInstitution> list=financeInstitutionMapper.selectByExample(financeInstitutionExample);
            if (list.size()!=0) return list.get(0);
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: FinanceInstitution financeInstitution
     * @Return: 执行结果
     * @Description: 更新金融机构账户信息
     */
    public int updateFinance(FinanceInstitution financeInstitution){
        int result=0;
        try {
            result=financeInstitutionMapper.updateByPrimaryKey(financeInstitution);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param:
     * @Return: List<FinanceInstitution>
     * @Description: 查找所有持有碳信的及金融机构
     */
    public List<FinanceInstitution> getFinanceHaveTicket(){
        FinanceInstitutionExample financeInstitutionExample=new FinanceInstitutionExample();
        FinanceInstitutionExample.Criteria criteria=financeInstitutionExample.createCriteria();
        criteria.andCompanyNameIsNotNull();
        criteria.andCarbonTicketNumberNotEqualTo(0);
        try {
            return financeInstitutionMapper.selectByExample(financeInstitutionExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
