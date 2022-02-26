package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.TicketVo;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xpc2000
 * @Date: 2022/02/26
 * @Description:
 */
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    CheckService checkService;

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo,String operator
     * @Return: Result
     * @Description: 创建碳信
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Result create(@RequestBody TicketVo table,@RequestParam String operator){
        Boolean privilege=checkService.controlChainCheck(table.getAccountName(),table.getActionPassword(),0);
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        //插入碳信创建记录，并修改各账户碳信余额
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 发行碳信
     */
    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public Result publish(@RequestBody TicketVo table){
        Boolean privilege=checkService.controlCheck(table.getAccountName(),table.getActionPassword(),1,table.getAccountType());
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        //插入碳信发行记录，，并修改各账户碳信余额
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description: 接收发行碳信
     */
    @RequestMapping(value = "/publishCheck",method = RequestMethod.PUT)
    public Result publishCheck(@RequestBody TicketVo table){
        Boolean privilege=checkService.reductionCheck(table.getAccountName(),table.getActionPassword(),3, table.getAccountType());
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return: Result
     * @Description:
     */
    @RequestMapping(value = "/transfer",method = RequestMethod.POST)
    public Result transfer(@RequestBody TicketVo table){
        Boolean privilege=checkService.reductionCheck(table.getAccountName(),table.getActionPassword(),4, table.getAccountType());
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return:
     * @Description:
     */
    @RequestMapping(value = "/transferCheck",method = RequestMethod.PUT)
    public Result transferCheck(@RequestBody TicketVo table){
        Boolean privilege=checkService.reductionCheck(table.getAccountName(),table.getActionPassword(),3, table.getAccountType());
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo
     * @Return:
     * @Description:
     */
    @RequestMapping(value = "/buyback",method = RequestMethod.POST)
    public Result buyback(@RequestBody TicketVo table){
        Boolean privilege=checkService.controlCheck(table.getAccountName(),table.getActionPassword(),4,table.getAccountType());
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        //插入碳信回购记录，并修改各账户碳信余额
        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: TicketVo,String operator
     * @Return:
     * @Description:
     */
    @RequestMapping(value = "/destroy",method = RequestMethod.POST)
    public Result destroy(@RequestBody TicketVo table, @RequestParam String operator){
        Boolean privilege=checkService.controlChainCheck(table.getAccountName(),table.getActionPassword(),0);
        if(!privilege) return new Result(ResponseCode.InsufficientPermissions);
        //插入碳信销毁记录，并修改各账户碳信余额
        return new Result();
    }
}
