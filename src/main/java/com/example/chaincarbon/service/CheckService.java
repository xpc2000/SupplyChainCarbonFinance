package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.*;
import com.example.chaincarbon.model.pojo.*;
import com.example.chaincarbon.utils.AccountType;
import com.example.chaincarbon.utils.ActionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 权限验证子模块
 */
@Service
public class CheckService {

    @Autowired
    FinanceDao financeDao;

    @Autowired
    ControlCoreDao controlCoreDao;

    @Autowired
    ControlSubDao controlSubDao;

    @Autowired
    ReduceCoreDao reduceCoreDao;

    @Autowired
    ReduceSubDao reduceSubDao;

    public boolean financeCheck(String name, String actionPassword, int actionType){
        boolean checkResult=false;
        FinanceInstitution financeInstitution;
        //碳质押模块审批
        if (actionType== ActionType.ExaminPledge.getCode()){
            financeInstitution=financeDao.getFinance(name);
            checkResult= financeInstitution != null && Objects.equals(financeInstitution.getPledgeApproval(), actionPassword);
        }
        //碳质押模块金融企业签约
        else if (actionType==ActionType.FinanceSignPledge.getCode()){
            financeInstitution=financeDao.getFinance(name);
            checkResult=financeInstitution!=null&& Objects.equals(financeInstitution.getPledgeSigning(), actionPassword);
        }
        //碳信融资模块审批
        else if(actionType==ActionType.ExaminFactor.getCode()){
            financeInstitution=financeDao.getFinance(name);
            checkResult=financeInstitution!=null&& Objects.equals(financeInstitution.getFactoringComplianceReview(), actionPassword);
        }
        //碳信融资模块金融企业签约
        else if(actionType==ActionType.FinanceSignFactor.getCode()){
            financeInstitution=financeDao.getFinance(name);
            checkResult=financeInstitution!=null&& Objects.equals(financeInstitution.getFactoringPurchaseSigning(), actionPassword);
        }
        return checkResult;
    }

    public boolean controlChainCheck(String name, String actionPassword, int actionType){
        boolean checkResult=false;
        ControlCore controlCore;
        //减排计划录入
        if (actionType==ActionType.ReductionPlan.getCode()){
            controlCore=controlCoreDao.getControlCore(name);
            checkResult=controlCore!=null&& Objects.equals(controlCore.getEmissionReductionPlan(), actionPassword);
        }
        //碳信创建
        else if (actionType==ActionType.CreateTicket.getCode()){
            controlCore=controlCoreDao.getControlCore(name);
            checkResult=controlCore!=null&& Objects.equals(controlCore.getCarbonTicketCreation(), actionPassword);
        }
        //碳信销毁
        else if(actionType==ActionType.DestroyTicket.getCode()){
            controlCore=controlCoreDao.getControlCore(name);
            checkResult=controlCore!=null&& Objects.equals(controlCore.getCarbonTicketDestruction(), actionPassword);
        }
        return checkResult;
    }

    public boolean controlCheck(String name, String actionPassword, int actionType,Integer accountType){
        boolean checkResult=false;
        ControlCore controlCore;
        ControlSub controlSub;
        //质押申请
        if(actionType==ActionType.ApplyPledge.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
                controlCore=controlCoreDao.getControlCore(name);
                checkResult=controlCore!=null&& Objects.equals(controlCore.getPledgeApplication(), actionPassword);
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询减排链链属企业的操作密码
                controlSub=controlSubDao.getControlSub(name);
                checkResult=controlSub!=null&& Objects.equals(controlSub.getPledgeApplication(), actionPassword);
            }
        }
        //质押签订
        else if(actionType==ActionType.CompanySignPledge.getCode()){
            if (Objects.equals(accountType, AccountType.ControlCore.getCode())){
                //查询控排链核心企业的操作密码
                controlCore=controlCoreDao.getControlCore(name);
                checkResult=controlCore!=null&& Objects.equals(controlCore.getPledgeSigning(), actionPassword);
            }
            else if (Objects.equals(accountType, AccountType.ControlSub.getCode())){
                //查询减排链链属企业的操作密码
                controlSub=controlSubDao.getControlSub(name);
                checkResult=controlSub!=null&& Objects.equals(controlSub.getPledgeSigning(), actionPassword);
            }
        }

        return checkResult;
    }

    public boolean reductionCheck(String name, String actionPassword, int actionType,Integer accountType){
        boolean checkResult=false;
        ReduceCore reduceCore;
        ReduceSub reduceSub;
        //融资申请
        if(actionType==ActionType.ApplyFactor.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
                reduceCore=reduceCoreDao.getReduceCore(name);
                checkResult=reduceCore!=null&& Objects.equals(reduceCore.getFinancialApplication(), actionPassword);
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
                reduceSub=reduceSubDao.getReduceSub(name);
                checkResult=reduceSub!=null&& Objects.equals(reduceSub.getFinancingApplication(), actionPassword);
            }
        }
        //碳信签收
        else if(actionType==ActionType.ReceiveTicket.getCode()){
            if (Objects.equals(accountType, AccountType.ReduceCore.getCode())){
                //查询减排链核心企业的操作密码
                reduceCore=reduceCoreDao.getReduceCore(name);
                checkResult=reduceCore!=null&& Objects.equals(reduceCore.getCarbonTicketSign(), actionPassword);
            }
            else if (Objects.equals(accountType, AccountType.ReduceSub.getCode())){
                //查询减排链链属企业的操作密码
                reduceSub=reduceSubDao.getReduceSub(name);
                checkResult=reduceSub!=null&& Objects.equals(reduceSub.getCarbonTicketSign(), actionPassword);
            }
        }
        return checkResult;
    }

}
