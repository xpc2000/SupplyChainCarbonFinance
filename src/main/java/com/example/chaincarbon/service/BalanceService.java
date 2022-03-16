package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.*;
import com.example.chaincarbon.model.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 各碳信账户碳配额/碳信余额或额度变更
 */
@Service
public class BalanceService {

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

    @Autowired
    ControlChainDao controlChainDao;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String chainName,Integer ticketLimit
     * @Return: 执行结果
     * @Description: 碳质押签约成功后修改控排链统一账户可创建碳信额度
     */
    public Boolean pledgeAfterSign(String chainName,Integer ticketLimit){
        ControlChain controlChain=controlChainDao.getControlChainByName(chainName);
        if(controlChain==null) return false;
        controlChain.setCreationCarbonTicket(controlChain.getCreationCarbonTicket()+ticketLimit);
        int result=controlChainDao.updateControlChain(controlChain);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String publisher, Integer num
     * @Return: 执行结果
     * @Description: 创建碳信涉及到的账户余额变动
     */
    public Boolean createRece(String publisher, Integer num){
        ControlSub controlSub;
        ControlCore controlCore=controlCoreDao.getControlCore(publisher);
        if(controlCore!=null) {
            controlCore.setCarbontTicket(controlCore.getCarbontTicket()+num);
            controlCore.setUnissuedCarbonTicket(controlCore.getUnissuedCarbonTicket()+num);
            int result=controlCoreDao.updateControlCore(controlCore);
            return result!=-1;
        }
        else {
            controlSub=controlSubDao.getControlSub(publisher);
            if(controlSub==null) return false;
            controlSub.setCatbonTicket(controlSub.getCatbonTicket()+num);
            controlSub.setUnissuedCarbonTicket(controlSub.getUnissuedCarbonTicket()+num);
            int result=controlSubDao.updateControlSub(controlSub);
            return result!=-1;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlCore controlCore,Integer num
     * @Return: 执行结果
     * @Description: 控排链核心企业发行碳信后变更账户余额
     */
    public Boolean publishCore(ControlCore controlCore,Integer num){
        controlCore.setUnissuedCarbonTicket(controlCore.getUnissuedCarbonTicket()-num);
        int result=controlCoreDao.updateControlCore(controlCore);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlSub controlSub,Integer num
     * @Return: 执行结果
     * @Description: 控排链链属企业发行碳信后变更碳信余额
     */
    public Boolean publishSub(ControlSub controlSub,Integer num) {
        controlSub.setUnissuedCarbonTicket(controlSub.getUnissuedCarbonTicket()-num);
        int result=controlSubDao.updateControlSub(controlSub);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ReduceCore reduceCore,Integer num
     * @Return: 执行结果
     * @Description: 减排链核心企业转让碳信后变更碳信余额
     */
    public Boolean transferCore(ReduceCore reduceCore,Integer num){
        reduceCore.setCarbonTicketBalance(reduceCore.getCarbonTicketBalance()-num);
        int result=reduceCoreDao.updateReduceCore(reduceCore);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ReduceSub reduceSub,Integer num
     * @Return: 执行结果
     * @Description: 减排链链属企业转让碳信后变更碳信余额
     */
    public Boolean transfetSub(ReduceSub reduceSub,Integer num){
        reduceSub.setCarbonTicketBalance(reduceSub.getCarbonTicketBalance()-num);
        int result=reduceSubDao.updateReduceSub(reduceSub);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: Integer num
     * @Return: 执行结果
     * @Description: 执行回购操作后后各账户余额变动
     */
    public Boolean buyback( Integer num){
        List<ReduceSub> reduceSubList=reduceSubDao.getReduceSubHaveTicket();
        List<ReduceSub> reduceSubList1=new ArrayList<>();
        Integer tmp=0;
        for (ReduceSub sub : reduceSubList) {
            tmp=sub.getCarbonTicketBalance();
            if (sub.getCarbonTicketBalance() <= num)
                sub.setCarbonTicketBalance(0);
            else sub.setCarbonTicketBalance(sub.getCarbonTicketBalance() - num);
            num -= tmp;
            reduceSubList1.add(sub);
            if (num <= 0) break;
        }
        for (ReduceSub reduceSub : reduceSubList1)
            reduceSubDao.updateReduceSub(reduceSub);

        if(num>0){
            List<ReduceCore> reduceCoreList=reduceCoreDao.getReduceCoreHaveTicket();
            List<ReduceCore> reduceCoreList1=new ArrayList<>();
            for(ReduceCore core:reduceCoreList){
                tmp=core.getCarbonTicketBalance();
                if(core.getCarbonTicketBalance() <= num)
                    core.setCarbonTicketBalance(0);
                else core.setCarbonTicketBalance(core.getCarbonTicketBalance()-num);
                num-= tmp;
                reduceCoreList1.add(core);
                if(num<=0) break;
            }
            for(ReduceCore reduceCore:reduceCoreList1)
                reduceCoreDao.updateReduceCore(reduceCore);
        }

        if(num>0){
            List<FinanceInstitution> financeInstitutionList=financeDao.getFinanceHaveTicket();
            List<FinanceInstitution> financeInstitutionList1=new ArrayList<>();
            for(FinanceInstitution finance:financeInstitutionList){
                tmp=finance.getCarbonTicketNumber();
                if(finance.getCarbonTicketNumber()<=num)
                    finance.setCarbonTicketNumber(0);
                else finance.setCarbonTicketNumber(finance.getCarbonTicketNumber()-num);
                num-=tmp;
                financeInstitutionList1.add(finance);
                if(num<=0) break;
            }

            for(FinanceInstitution financeInstitution:financeInstitutionList1)
                financeDao.updateFinance(financeInstitution);
        }
        return num <= 0;
    }


    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlCore controlCore, Integer num
     * @Return: 执行结果
     * @Description: 控排链核心企业回购碳信后账户余额变动
     */
    public Boolean buybackCore(ControlCore controlCore, Integer num){
        controlCore.setRepurchasedCarbonTicket(controlCore.getRepurchasedCarbonTicket()+num);
        int result=controlCoreDao.updateControlCore(controlCore);
        if (result==-1) return false;
        else return buyback(num);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlSub controlSub, Integer num
     * @Return: 执行结果
     * @Description: 减排链链属企业回购碳信后账户余额变动
     */
    public Boolean buybackSub(ControlSub controlSub, Integer num){
        controlSub.setRepurchasedCarbonTicket(controlSub.getRepurchasedCarbonTicket()+num);
        int result=controlSubDao.updateControlSub(controlSub);
        if(result==-1)return false;
        else return buyback(num);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ReduceCore reduceCore, Integer num
     * @Return: 执行结果
     * @Description: 减排链核心企业签收碳信后账户余额变动
     */
    public Boolean receiveCore(ReduceCore reduceCore, Integer num){
        reduceCore.setCarbonTicketBalance(reduceCore.getCarbonTicketBalance()+num);
        int result=reduceCoreDao.updateReduceCore(reduceCore);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ReduceSub reduceSub,Integer num
     * @Return: 执行结果
     * @Description: 减排链链属企业签收碳信后账户余额变动
     */
    public Boolean receiveSub(ReduceSub reduceSub,Integer num){
        System.out.println(reduceSub.getCarbonTicketBalance());
        reduceSub.setCarbonTicketBalance(reduceSub.getCarbonTicketBalance()+num);
        System.out.println(reduceSub.getCarbonTicketBalance());
        int result=reduceSubDao.updateReduceSub(reduceSub);
        return result!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String chain
     * @Return: 执行结果
     * @Description: 控排链执行碳信销毁后各账户余额变动
     */
    public boolean destroy(String chain){
        List<ControlCore> coreList=controlCoreDao.getControlCoreByChain(chain);
        List<ControlSub> subList=controlSubDao.getControlSubByChain(chain);
        boolean flag=true;
        for(ControlCore core:coreList){
            core.setCarbontTicket(0);;
            core.setRepurchasedCarbonTicket(0);
            core.setUnissuedCarbonTicket(0);
            core.setNumberCarbonEmission(0);
            flag=controlCoreDao.updateControlCore(core)!=-1;
            if (!flag) return false;
        }

        for (ControlSub sub:subList){
            sub.setCatbonTicket(0);
            sub.setRepurchasedCarbonTicket(0);
            sub.setUnissuedCarbonTicket(0);
            sub.setNumberCarbonEmission(0);
            flag=controlSubDao.updateControlSub(sub)!=-1;
            if (!flag) return false;
        }

        ControlChain chain1=controlChainDao.getControlChainByName(chain);
        if(chain1==null) return false;
        chain1.setCreationCarbonTicket(0);
        return flag;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name,Integer num
     * @Return: 执行结果
     * @Description: 金融机构接收碳信余额
     */
    public boolean financeRece(String name,Integer num){
        FinanceInstitution financeInstitution=financeDao.getFinance(name);
        financeInstitution.setCarbonTicketNumber(financeInstitution.getCarbonTicketNumber()+num);
        int result=financeDao.updateFinance(financeInstitution);
        return result!=-1;
    }

}
