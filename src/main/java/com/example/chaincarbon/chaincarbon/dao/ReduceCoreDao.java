package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.ReduceCoreMapper;
import com.example.chaincarbon.model.pojo.ReduceCore;
import com.example.chaincarbon.model.pojo.ReduceCoreExample;
import com.example.chaincarbon.model.pojo.ReduceSub;
import com.example.chaincarbon.model.pojo.ReduceSubExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 减排链核心企业的CRUD
 */
@Repository
public class ReduceCoreDao {

    @Autowired
    ReduceCoreMapper reduceCoreMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: ReduceCore
     * @Description: 通过主键获取减排链核心企业
     */
    public ReduceCore getReduceCore(String name){

        try{
            return reduceCoreMapper.selectByPrimaryKey(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String email
     * @Return: ReduceCore
     * @Description: 通过邮箱获取减排链核心企业
     */
    public ReduceCore getReduceCoreByEmail(String email){
        ReduceCoreExample reduceCoreExample=new ReduceCoreExample();
        ReduceCoreExample.Criteria criteria=reduceCoreExample.createCriteria();
        criteria.andEmailEqualTo(email);
        try{
            List<ReduceCore> list=reduceCoreMapper.selectByExample(reduceCoreExample);
            if(list.size()!=0) return list.get(0);
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ReduceCore reduceCore
     * @Return: 执行结果
     * @Description: 更新减排链核心企业
     */
    public int updateReduceCore(ReduceCore reduceCore){
        int result=0;
        try {
            result=reduceCoreMapper.updateByPrimaryKey(reduceCore);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return  result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param:
     * @Return: List<ReduceCore>
     * @Description: 查找持有碳信的减排链核心企业
     */
    public List<ReduceCore> getReduceCoreHaveTicket(){
        ReduceCoreExample reduceCoreExample=new ReduceCoreExample();
        ReduceCoreExample.Criteria criteria=reduceCoreExample.createCriteria();
        criteria.andNameIsNotNull();
        criteria.andCarbonTicketBalanceNotEqualTo(0);
        try {
            return reduceCoreMapper.selectByExample(reduceCoreExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
