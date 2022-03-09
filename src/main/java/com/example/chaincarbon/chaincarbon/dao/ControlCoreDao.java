package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.ControlCoreMapper;
import com.example.chaincarbon.model.pojo.ControlCore;
import com.example.chaincarbon.model.pojo.ControlCoreExample;
import com.example.chaincarbon.model.pojo.FinanceInstitution;
import com.example.chaincarbon.model.pojo.FinanceInstitutionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 控排链核心企业的CRUD
 */
@Repository
public class ControlCoreDao {

    @Autowired
    ControlCoreMapper controlCoreMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: ControlCore
     * @Description: 通过主键获取控排链核心企业
     */
    public ControlCore getControlCore(String name){
        try{
            return controlCoreMapper.selectByPrimaryKey(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String email
     * @Return: ControlCore
     * @Description: 通过邮箱返回控排链核心企业
     */
    public ControlCore getControlCoreByEmail(String email){
        ControlCoreExample controlCoreExample=new ControlCoreExample();
        ControlCoreExample.Criteria criteria=controlCoreExample.createCriteria();
        criteria.andEmailEqualTo(email);
        try{
            List<ControlCore> list=controlCoreMapper.selectByExample(controlCoreExample);
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
     * @Param: ControlCore controlCore
     * @Return: 执行结果
     * @Description: 更新控排链核心企业信息
     */
    public int updateControlCore(ControlCore controlCore){
        int result=0;
        try{
            result=controlCoreMapper.updateByPrimaryKey(controlCore);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String chain
     * @Return: List<ControlCore>
     * @Description: 返回同属一个控排链的核心企业
     */
    public List<ControlCore> getControlCoreByChain(String chain){
        ControlCoreExample controlCoreExample=new ControlCoreExample();
        ControlCoreExample.Criteria criteria=controlCoreExample.createCriteria();
        criteria.andControlChainEqualTo(chain);
        try {
            return controlCoreMapper.selectByExample(controlCoreExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
