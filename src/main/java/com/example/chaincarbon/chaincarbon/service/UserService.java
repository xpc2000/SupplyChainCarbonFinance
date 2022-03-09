package com.example.chaincarbon.service;

import com.example.chaincarbon.dao.*;
import com.example.chaincarbon.model.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 用户信息子模块
 */
@Service
public class UserService {
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

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: String name
     * @Return: FinanceInstitution
     * @Description: 获取金融机构账户信息
     */
    public FinanceInstitution getFIAccount(String name){
        return financeDao.getFinance(name);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: String name
     * @Return: ControlCore
     * @Description: 获取控排链核心企业账户信息
     */
    public ControlCore getCCAccount(String name){
        return controlCoreDao.getControlCore(name);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: String name
     * @Return: ControlSub
     * @Description: 获取控排链链属企业账户信息
     */
    public ControlSub getCSAccount(String name){
        return controlSubDao.getControlSub(name);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: String name
     * @Return: ReduceCore
     * @Description: 获取减排链核心企业账户信息
     */
    public ReduceCore getRCAccount(String name){
        return reduceCoreDao.getReduceCore(name);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/07
     * @Param: String name
     * @Return: ReduceSub
     * @Description: 获取减排链链属企业账户信息
     */
    public ReduceSub getRSAccount(String name){
        return reduceSubDao.getReduceSub(name);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/09
     * @Param: ControlCore controlCore
     * @Return: boolean
     * @Description: 碳质押成功后控排链核心企业修改质押碳配额数量
     */
    public boolean updateControlCoreEmission(ControlCore controlCore){
        return controlCoreDao.updateControlCore(controlCore)!=-1;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/09
     * @Param: ControlSub controlSub
     * @Return: boolean
     * @Description: 碳质押成功后控排链链属企业修改碳配额数量
     */
    public boolean updateControlSubEmission(ControlSub controlSub){
        return controlSubDao.updateControlSub(controlSub)!=-1;
    }
}
