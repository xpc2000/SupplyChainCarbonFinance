package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.PlanMapper;
import com.example.chaincarbon.model.pojo.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 减排计划的CRUD
 */
@Repository
public class PlanDao {
    @Autowired
    PlanMapper planMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Plan plan
     * @Return: 执行结果
     * @Description: 插入减排计划
     */
    public int insertPlan(Plan plan){
        int result=0;
        try{
            result=planMapper.insertSelective(plan);
        } catch (Exception e) {
            result=-1;
            e.printStackTrace();
        }
        return result;
    }
}
