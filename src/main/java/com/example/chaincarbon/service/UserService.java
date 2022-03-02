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


    public FinanceInstitution getFIAccount(String name){
        return financeDao.getFinance(name);
    }

    public ControlCore getCCAccount(String name){
        return controlCoreDao.getControlCore(name);
    }

    public ControlSub getCSAccount(String name){
        return controlSubDao.getControlSub(name);
    }

    public ReduceCore getRCAccount(String name){
        return reduceCoreDao.getReduceCore(name);
    }

    public ReduceSub getRSAccount(String name){
        return reduceSubDao.getReduceSub(name);
    }
}
