package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.pojo.ControlCore;
import com.example.chaincarbon.model.pojo.ControlSub;
import com.example.chaincarbon.model.pojo.ReduceCore;
import com.example.chaincarbon.model.pojo.ReduceSub;
import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.TicketVo;
import com.example.chaincarbon.service.BalanceService;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.service.TicketService;
import com.example.chaincarbon.service.UserService;
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
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    UserService userService;

    @Autowired
    CheckService checkService;

    @Autowired
    BalanceService balanceService;

    @Autowired
    TicketService ticketService;

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo,String operator
     * @Return: Result
     * @Description: 创建碳信
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result create(@RequestBody TicketVo table){
        boolean privilege=checkService.controlChainCheck(table.getAccountName(),table.getActionPassword(),0);
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        //插入碳信创建记录，并修改各账户碳信余额
        Boolean dbResult=ticketService.insertTicketRecord(table,1);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 发行碳信
     */
    @RequestMapping(value = "/publish",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result publish(@RequestBody TicketVo table){
        ControlCore controlCore;
        ControlSub controlSub;
        if(Objects.equals(table.getAccountType(), AccountType.ControlCore.getCode())){
            controlCore= userService.getCCAccount(table.getAccountName());
            if(controlCore==null|| !Objects.equals(controlCore.getCarbonTicketIssue(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.publishCore(controlCore,table.getNum())) return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(table.getAccountType(), AccountType.ControlSub.getCode())){
            controlSub=userService.getCSAccount(table.getAccountName());
            if(controlSub==null|| !Objects.equals(controlSub.getCarbonTicketIssue(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.publishSub(controlSub,table.getNum())) return new Result(ResponseCode.DataBaseError);
        }
        //插入碳信发行记录，，并修改各账户碳信余额
        Boolean dbResult=ticketService.insertTicketRecord(table,2);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo，ticketNum(碳信数量)
     * @Return: Result
     * @Description: 接收发行碳信
     */
    @RequestMapping(value = "/publishCheck",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public Result publishCheck(@RequestBody ActionVo table,@RequestParam("tickeNum") Integer ticketNum){
//        boolean privilege=checkService.reductionCheck(table.getAccountName(),table.getActionPassword(),3, table.getAccountType());
//        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        ReduceCore reduceCore=userService.getRCAccount(table.getAccountName());
        if(reduceCore==null|| !Objects.equals(reduceCore.getCarbonTicketSign(), table.getActionPassword()))
            return new Result(ResponseCode.InsufficientPermissions);
        if(!balanceService.receiveCore(reduceCore, ticketNum)) return  new Result(ResponseCode.DataBaseError);
        Boolean dbResult=ticketService.updateTicket(table.getID(), table.getComment());
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 转让碳信
     */
    @RequestMapping(value = "/transfer",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result transfer(@RequestBody TicketVo table){
        ReduceCore reduceCore;
        ReduceSub reduceSub;
        if(Objects.equals(table.getAccountType(), AccountType.ReduceCore.getCode())){
            reduceCore= userService.getRCAccount(table.getAccountName());
            if(reduceCore==null|| !Objects.equals(reduceCore.getCarbonTicketTransfer(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if (!balanceService.transferCore(reduceCore,table.getNum()))
                return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(table.getAccountType(), AccountType.ControlSub.getCode())){
            reduceSub=userService.getRSAccount(table.getAccountName());
            if(reduceSub==null|| !Objects.equals(reduceSub.getCarbonTicketTranfer(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.transfetSub(reduceSub,table.getNum()))
                return new Result(ResponseCode.OK);
        }
        Boolean dbResult=ticketService.insertTicketRecord(table,3);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo，ticketNum(碳信数量)
     * @Return: Result
     * @Description: 接收转让碳信
     */
    @RequestMapping(value = "/transferCheck",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    public Result transferCheck(@RequestBody ActionVo table,@RequestParam("ticketNum") Integer ticketNum){
        ReduceCore reduceCore;
        ReduceSub reduceSub;
        if(Objects.equals(table.getAccountType(), AccountType.ReduceCore.getCode())){
            reduceCore= userService.getRCAccount(table.getAccountName());
            if(reduceCore==null|| !Objects.equals(reduceCore.getCarbonTicketSign(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if (!balanceService.receiveCore(reduceCore,ticketNum))
                return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(table.getAccountType(), AccountType.ControlSub.getCode())){
            reduceSub=userService.getRSAccount(table.getAccountName());
            if(reduceSub==null|| !Objects.equals(reduceSub.getCarbonTicketSign(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.transfetSub(reduceSub,ticketNum))
                return new Result(ResponseCode.DataBaseError);
        }
        Boolean dbResult=ticketService.updateTicket(table.getID(), table.getComment());
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 回购碳信
     */
    @RequestMapping(value = "/buyback",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result buyback(@RequestBody TicketVo table){
        ControlCore controlCore;
        ControlSub controlSub;
        if(Objects.equals(table.getAccountType(), AccountType.ControlCore.getCode())){
            controlCore= userService.getCCAccount(table.getAccountName());
            if(controlCore==null|| !Objects.equals(controlCore.getCarbonTicketRepurchase(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.buybackCore(controlCore, table.getNum()))
                return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(table.getAccountType(), AccountType.ControlSub.getCode())) {
            controlSub = userService.getCSAccount(table.getAccountName());
            if (controlSub == null || !Objects.equals(controlSub.getCarbonTicketRepurchase(), table.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方碳信余额
            if(!balanceService.buybackSub(controlSub, table.getNum()))
                return new Result(ResponseCode.DataBaseError);
        }
        //插入碳信回购记录，并修改各账户碳信余额
        Boolean dbResult=ticketService.insertTicketRecord(table,4);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 碳信销毁
     */
    @RequestMapping(value = "/destroy",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result destroy(@RequestBody TicketVo table){
        ControlCore controlCore=userService.getCCAccount(table.getAccountName());
        if(!Objects.equals(controlCore.getCarbonTicketDestruction(), table.getActionPassword()))
            return new Result(ResponseCode.InsufficientPermissions);
        if(!balanceService.destroy(table.getSenderChain())) return new Result(ResponseCode.DataBaseError);
        //插入碳信销毁记录，并修改各账户碳信余额
        Boolean dbResult=ticketService.insertTicketRecord(table,6);
        if (!dbResult) return new Result(ResponseCode.DataBaseError);
        return new Result(ResponseCode.OK);
    }

}
