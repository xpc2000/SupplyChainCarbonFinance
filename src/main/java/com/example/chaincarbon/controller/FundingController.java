package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyFactorVo;
import com.example.chaincarbon.model.vo.FactorVo;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
/**
 * @Author: xpc2000
 * @Date: 2022/02/26
 * @Description:
 */
@RestController
@RequestMapping(value = "/fund")
public class FundingController {

    @Autowired
    CheckService checkService;

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ApplyFactorVo
     * @Return: Result
     * @Description:
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(@RequestBody ApplyFactorVo applyFactorVo){
        Boolean check=checkService.reductionCheck(applyFactorVo.getAccountName(),applyFactorVo.getActionPassword(),20,applyFactorVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ActionVo
     * @Return: Result
     * @Description:
     */
    @RequestMapping(value = "/examine",method = RequestMethod.PUT)
    public Result examine(@RequestBody ActionVo actionVo){
        Boolean check=checkService.financeCheck(actionVo.getAccountName(),actionVo.getActionPassword(),21);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: FactorVo
     * @Return: Result
     * @Description:
     */
    @RequestMapping(value = "/financeSign",method = RequestMethod.PUT)
    public Result financeSign(@RequestBody FactorVo factorVo){
        Boolean check=checkService.financeCheck(factorVo.getAccountName(),factorVo.getActionPassword(),22);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ActionVo
     * @Return: Result
     * @Description:
     */
    @RequestMapping(value = "/companySign",method = RequestMethod.PUT)
    public Result companySign(@RequestBody ActionVo actionVo){
        Boolean check=checkService.reductionCheck(actionVo.getAccountName(),actionVo.getActionPassword(),20,actionVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }
}
