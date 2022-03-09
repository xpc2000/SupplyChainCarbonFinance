package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.ReduceSubMapper;
import com.example.chaincarbon.model.pojo.ReduceCore;
import com.example.chaincarbon.model.pojo.ReduceSub;
import com.example.chaincarbon.model.pojo.ReduceSubExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 减排链链属企业的CRUD
 */
@Repository
public class ReduceSubDao {
    @Autowired
    ReduceSubMapper reduceSubMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: ReduceSub
     * @Description: 通过主键获取减排链链属企业
     */
    public ReduceSub getReduceSub(String name){
        try{
            return reduceSubMapper.selectByPrimaryKey(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String email
     * @Return: ReduceSub
     * @Description: 通过邮箱获取减排链链属企业
     */
    public ReduceSub getReduceSubByEmail(String email){
        ReduceSubExample reduceSubExample=new ReduceSubExample();
        ReduceSubExample.Criteria criteria=reduceSubExample.createCriteria();
        criteria.andEmailEqualTo(email);
        try{
            List<ReduceSub> list=reduceSubMapper.selectByExample(reduceSubExample);
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
     * @Param: ReduceSub reduceSub
     * @Return: 执行结果
     * @Description: 更新减排链链属企业
     */
    public int updateReduceSub(ReduceSub reduceSub){
        int result=0;
        try {
            result=reduceSubMapper.updateByPrimaryKey(reduceSub);
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
     * @Return: List<ReduceSub>
     * @Description: 获取持有碳信的减排链链属企业
     */
    public List<ReduceSub> getReduceSubHaveTicket(){
        ReduceSubExample reduceSubExample=new ReduceSubExample();
        ReduceSubExample.Criteria criteria=reduceSubExample.createCriteria();
        criteria.andNameIsNotNull();
        criteria.andCarbonTicketBalanceNotEqualTo(0);
        try {
            return reduceSubMapper.selectByExample(reduceSubExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
