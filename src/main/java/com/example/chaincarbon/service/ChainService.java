package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.PlanDao;
import com.example.chaincarbon.model.pojo.Plan;
import com.example.chaincarbon.model.vo.PlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 绿色供应链管理子模块
 */
@Service
public class ChainService {
    @Autowired
    PlanDao planDao;


    public Boolean insertPlan(PlanVo planVo)  {
        Plan plan=new Plan();
        plan.setControlChain(planVo.getChain());
        plan.setAmountReduce(planVo.getReductionNum());
        plan.setCompany(planVo.getCompany());
        plan.setDeclarationCarbonTicket(planVo.getTicketNum());
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= null;
        try {
            date = fmt.parse(planVo.getYear());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        plan.setYear(date);
        int result=planDao.insertPlan(plan);
        return result != -1;
    }
}
