package com.example.chaincarbon.service;

import com.example.chaincarbon.utils.AccountType;
import com.example.chaincarbon.utils.ActionType;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Objects;

@Service
public class CheckService {

    public Boolean financeCheck(String name, String actionPassword, int actionType){
        Boolean checkResult=false;
        //碳质押模块审批
        if (actionType== ActionType.ExaminPledge.getCode()){

        }
        //碳质押模块金融企业签约
        else if (actionType==ActionType.FinanceSignPledge.getCode()){

        }
        //碳信融资模块审批
        else if(actionType==ActionType.ExaminFactor.getCode()){

        }
        //碳信融资模块金融企业签约
        else if(actionType==ActionType.FinanceSignFactor.getCode()){

        }

        return checkResult;
    }

    public Boolean controlChainCheck(String name, String actionPassword, int actionType){
        Boolean checkResult=false;
        //减排计划录入
        if (actionType==ActionType.ReductionPlan.getCode()){

        }
        //碳信创建
        else if (actionType==ActionType.CreateTicket.getCode()){

        }
        //碳信销毁
        else if(actionType==ActionType.DestroyTicket.getCode()){

        }
        return checkResult;
    }

    public Boolean controlCheck(String name, String actionPassword, int actionType,Integer accountType){
        Boolean checkResult=false;
        //质押申请
        if(actionType==ActionType.ApplyPledge.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //质押签订
        else if(actionType==ActionType.CompanySignPledge.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //碳信发行
        else if(actionType==ActionType.PublishTicket.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //碳信回购
        else if(actionType==ActionType.BuyBackTicket.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询控排链链属企业的操作密码
            }
        }
        return checkResult;
    }

    public Boolean reductionCheck(String name, String actionPassword, int actionType,Integer accountType){
        Boolean checkResult=false;
        //融资申请
        if(actionType==ActionType.ApplyFactor.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //融资签订
        else if(actionType== ActionType.CompanySignFactor.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //碳信签收
        else if(actionType==ActionType.ReceiveTicket.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        //碳信转让
        else if(actionType==ActionType.TransferTicket.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
            }
        }
        return checkResult;
    }
}
