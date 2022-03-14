package com.example.chaincarbon.controller;

import com.example.chaincarbon.dao.*;
import com.example.chaincarbon.model.pojo.*;
import com.example.chaincarbon.model.vo.ControlVo;
import com.example.chaincarbon.model.vo.LoginVo;
import com.example.chaincarbon.model.vo.UserVo;
import com.example.chaincarbon.service.UserService;
import com.example.chaincarbon.utils.AccountType;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
public class UserController {

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

    //get the company data
    @RequestMapping(value = "/getCompanySummary",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Result getCompanySummary(@RequestParam String email, @RequestParam Integer type){
        Result result=new Result(ResponseCode.LoginFailure);
        if (type == 1) {
            ControlCore controlCore = controlCoreDao.getControlCoreByEmail(email);
            ControlVo controlVo = new ControlVo();
            controlVo.setName(controlCore.getName());
            controlVo.setChain(controlCore.getControlChain());
            controlVo.setCarbonLimit(controlCore.getCarbontTicket());
            controlVo.setEmissionPledged(controlCore.getNumberCarbonEmission());
            controlVo.setTicketUnissued(controlCore.getUnissuedCarbonTicket());
            controlVo.setTicketBuyback(controlCore.getRepurchasedCarbonTicket());
            result.setData(controlVo);
        }
        else if (type == 2) {
            ControlSub controlSub = controlSubDao.getControlSubByEmail(email);
            ControlVo controlVo = new ControlVo();
            controlVo.setName(controlSub.getName());
            controlVo.setChain(controlSub.getControlChain());
            controlVo.setCarbonLimit(controlSub.getCatbonTicket());
            controlVo.setEmissionPledged(controlSub.getNumberCarbonEmission());
            controlVo.setTicketUnissued(controlSub.getUnissuedCarbonTicket());
            controlVo.setTicketBuyback(controlSub.getRepurchasedCarbonTicket());
            result.setData(controlVo);
        }
        else if (type==3){
            ReduceCore reduceCore = reduceCoreDao.getReduceCoreByEmail(email);
            UserVo userVo=new UserVo();
            userVo.setName(reduceCore.getName());
            userVo.setChain(reduceCore.getReduceChain());
            userVo.setCarbinTicket(reduceCore.getCarbonTicketBalance());
            result.setData(userVo);
        }
        else if (type==4){
            ReduceSub reduceSub = reduceSubDao.getReduceSubByEmail(email);
            UserVo userVo=new UserVo();
            userVo.setName(reduceSub.getName());
            userVo.setChain(reduceSub.getReduceChain());
            userVo.setCarbinTicket(reduceSub.getCarbonTicketBalance());
            result.setData(userVo);
        }

        return result;
    }



    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: LoginVo
     * @Return: Result
     * @Description: 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result login(@RequestBody LoginVo loginVo){
//        String checkResult= userService.loginCheck(loginVo.getUserEmail(),loginVo.getPassword(),loginVo.getAccountType());
        //成功返回账户信息，失败返回失败提示
        Result result=new Result(ResponseCode.LoginFailure);
        if(Objects.equals(loginVo.getAccountType(), AccountType.Finance.getCode())){
            FinanceInstitution financeInstitution=financeDao.getFinanceByEmail(loginVo.getUserEmail());
            if(financeInstitution!=null&& Objects.equals(financeInstitution.getLoginPassword(), loginVo.getPassword())){
                result.setConde(ResponseCode.OK.getCode());
                result.setMessage(ResponseCode.OK.getMessage());
                //数据包装
                UserVo userVo=new UserVo();
                userVo.setName(financeInstitution.getCompanyName());
                userVo.setChain("金融业");
                userVo.setCarbinTicket(financeInstitution.getCarbonTicketNumber());
                result.setData(userVo);
            }
        }
        else if(Objects.equals(loginVo.getAccountType(), AccountType.ControlCore.getCode())){
            ControlCore controlCore=controlCoreDao.getControlCoreByEmail(loginVo.getUserEmail());
            if(controlCore!=null&& Objects.equals(controlCore.getLogin(), loginVo.getPassword())){
                result.setConde(ResponseCode.OK.getCode());
                result.setMessage(ResponseCode.OK.getMessage());
                //数据包装
                ControlVo controlVo=new ControlVo();
                controlVo.setName(controlCore.getName());
                controlVo.setChain(controlCore.getControlChain());
                controlVo.setCarbonLimit(controlCore.getCarbontTicket());
                controlVo.setEmissionPledged(controlCore.getNumberCarbonEmission());
                controlVo.setTicketUnissued(controlCore.getUnissuedCarbonTicket());
                controlVo.setTicketBuyback(controlCore.getRepurchasedCarbonTicket());
                result.setData(controlVo);
            }
        }

        else if (Objects.equals(loginVo.getAccountType(), AccountType.ControlSub.getCode())){
            ControlSub controlSub=controlSubDao.getControlSubByEmail(loginVo.getUserEmail());
            if(controlSub!=null&& Objects.equals(controlSub.getLogin(), loginVo.getPassword())){
                result.setConde(ResponseCode.OK.getCode());
                result.setMessage(ResponseCode.OK.getMessage());
                //数据包装
                ControlVo controlVo=new ControlVo();
                controlVo.setName(controlSub.getName());
                controlVo.setChain(controlSub.getControlChain());
                controlVo.setCarbonLimit(controlSub.getCatbonTicket());
                controlVo.setEmissionPledged(controlSub.getNumberCarbonEmission());
                controlVo.setTicketUnissued(controlSub.getUnissuedCarbonTicket());
                controlVo.setTicketBuyback(controlSub.getRepurchasedCarbonTicket());
                result.setData(controlVo);
            }
        }

        else if(Objects.equals(loginVo.getAccountType(), AccountType.ReduceCore.getCode())){
            ReduceCore reduceCore=reduceCoreDao.getReduceCoreByEmail(loginVo.getUserEmail());
            if(reduceCore!=null&& Objects.equals(reduceCore.getLogin(), loginVo.getPassword())){
                result.setConde(ResponseCode.OK.getCode());
                result.setMessage(ResponseCode.OK.getMessage());
                //数据包装
                UserVo userVo=new UserVo();
                userVo.setName(reduceCore.getName());
                userVo.setChain(reduceCore.getReduceChain());
                userVo.setCarbinTicket(reduceCore.getCarbonTicketBalance());
                result.setData(userVo);
            }
        }

        else{
            ReduceSub reduceSub=reduceSubDao.getReduceSubByEmail(loginVo.getUserEmail());
            if(reduceSub!=null&& Objects.equals(reduceSub.getLogin(), loginVo.getPassword())){
                result.setConde(ResponseCode.OK.getCode());
                result.setMessage(ResponseCode.OK.getMessage());
                //数据包装
                UserVo userVo=new UserVo();
                userVo.setName(reduceSub.getName());
                userVo.setChain(reduceSub.getReduceChain());
                userVo.setCarbinTicket(reduceSub.getCarbonTicketBalance());
                result.setData(userVo);
            }
        }
        return result;
    }


}
