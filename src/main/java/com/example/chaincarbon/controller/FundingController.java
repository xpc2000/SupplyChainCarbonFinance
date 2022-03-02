package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.pojo.ReduceCore;
import com.example.chaincarbon.model.pojo.ReduceSub;
import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyFactorVo;
import com.example.chaincarbon.model.vo.FactorVo;
import com.example.chaincarbon.service.*;
import com.example.chaincarbon.utils.AccountType;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @Autowired
    FundingService fundingService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @Autowired
    BalanceService balanceService;

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ApplyFactorVo
     * @Return: Result
     * @Description: 减排链企业申请供应链金融服务（本demo中以保理为例）
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(@RequestBody ApplyFactorVo applyFactorVo){
        boolean check=checkService.reductionCheck(applyFactorVo.getAccountName(),applyFactorVo.getActionPassword(),20,applyFactorVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=fundingService.apply(applyFactorVo);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        else return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ActionVo
     * @Return: Result
     * @Description: 金融机构对控排链企业的申请进行合规检查
     */
    @RequestMapping(value = "/examine",method = RequestMethod.PUT)
    public Result examine(@RequestBody ActionVo actionVo){
        boolean check=checkService.financeCheck(actionVo.getAccountName(),actionVo.getActionPassword(),21);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=fundingService.examine(actionVo.getComment(), actionVo.getID());
        if(!dbResult) return new Result(ResponseCode.DataBaseError);
        else return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: FactorVo
     * @Return: Result
     * @Description: 金融机构对供应链申请提出融资条件并签约
     */
    @RequestMapping(value = "/financeSign",method = RequestMethod.PUT)
    public Result financeSign(@RequestBody FactorVo factorVo){
        boolean check=checkService.financeCheck(factorVo.getAccountName(),factorVo.getActionPassword(),22);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=fundingService.financeFactor(factorVo);
        if(!dbResult) return new Result(ResponseCode.DataBaseError);
        else return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: ActionVo，ticketNum(碳信数量)
     * @Return: Result
     * @Description: 减排链企业决定是否答应金融机构提出的融资条件
     */
    @RequestMapping(value = "/companySign",method = RequestMethod.PUT)
    public Result companySign(@RequestBody ActionVo actionVo, @RequestParam Integer ticketNUm){
        ReduceCore reduceCore;
        ReduceSub reduceSub;
        String chain="";
        if(Objects.equals(actionVo.getAccountType(), AccountType.ReduceCore.getCode())){
            reduceCore= userService.getRCAccount(actionVo.getAccountName());
            if(reduceCore==null|| !Objects.equals(reduceCore.getFinancingContract(), actionVo.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            chain=reduceCore.getReduceChain();
            //修改转让方碳信余额
            if(!balanceService.transferCore(reduceCore,ticketNUm)) return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(actionVo.getAccountType(), AccountType.ControlSub.getCode())){
            reduceSub=userService.getRSAccount(actionVo.getAccountName());
            if(reduceSub==null|| !Objects.equals(reduceSub.getFinancingContract(), actionVo.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            chain=reduceSub.getReduceChain();
            //修改转让方碳信余额
            if(balanceService.transfetSub(reduceSub,ticketNUm)) return new Result(ResponseCode.DataBaseError);
        }
        //修改金融机构碳信余额
        Boolean dbResult=fundingService.companyFactor(actionVo.getComment(), actionVo.getID());
        if(!dbResult) return new Result(ResponseCode.DataBaseError);
        String finance=ticketService.ticketFactor(actionVo.getID(), chain);
        //BalanceService更改账户余额
        if(finance==null) return new Result(ResponseCode.DataBaseError);
        boolean checkResult=balanceService.financeRece(finance,ticketNUm);
        if ((!checkResult)) return new Result(ResponseCode.DataBaseError);
        else return new Result(ResponseCode.OK);
    }
}
