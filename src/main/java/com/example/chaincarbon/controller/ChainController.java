package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.PlanVo;
import com.example.chaincarbon.service.ChainService;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.text.ParseException;

/**
 * @Author: xpc2000
 * @Date:2022/2/26
 * @Description: 绿色供应链管理模块
 */
@RestController
@RequestMapping(value="/chain")
public class ChainController {

    @Autowired
    CheckService checkService;

    @Autowired
    ChainService chainService;

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: PlanVo
     *@Return: Result(成功或失败)
     *@Description: 提交减排计划
     */
    @RequestMapping(value = "/plan",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result submitPlan(@RequestBody PlanVo planVo) throws ParseException {
        boolean check=checkService.controlChainCheck(planVo.getAccountName(),planVo.getActionPassword(),30);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean insertResult= chainService.insertPlan(planVo);
        if (!insertResult) return new Result(ResponseCode.DataBaseError);
        else return new Result(ResponseCode.OK);
    }
}
