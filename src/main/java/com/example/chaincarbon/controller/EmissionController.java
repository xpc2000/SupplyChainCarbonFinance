package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.pojo.ControlCore;
import com.example.chaincarbon.model.pojo.ControlSub;
import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyPledgeVo;
import com.example.chaincarbon.model.vo.PledgeVo;
import com.example.chaincarbon.service.BalanceService;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.service.EmissionService;
import com.example.chaincarbon.service.UserService;
import com.example.chaincarbon.utils.AccountType;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author: xpc2000
 * @Date:2022/2/26
 * @Description:
 */

@RestController
@RequestMapping(value = "/pledge")
public class EmissionController {

    @Autowired
    CheckService checkService;

    @Autowired
    EmissionService emissionService;

    @Autowired
    UserService userService;

    @Autowired
    BalanceService balanceService;

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ApplyPledgeVo
     *@Return: Result
     *@Description: 控排链企业提交碳质押申请
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(@RequestBody ApplyPledgeVo applyPledgeVo){
        boolean check=checkService.controlCheck(applyPledgeVo.getAccountName(),applyPledgeVo.getActionPassword(),10,applyPledgeVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=emissionService.apply(applyPledgeVo);
        if (dbResult) return new Result(ResponseCode.OK);
        else return new Result(ResponseCode.DataBaseError);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ActionVo
     *@Return: Result
     *@Description: 金融机构审核碳质押申请
     */
    @RequestMapping(value = "/examine",method = RequestMethod.PUT)
    public Result examine(@RequestBody ActionVo actionVo){
        boolean check=checkService.financeCheck(actionVo.getAccountName(),actionVo.getActionPassword(),11);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=emissionService.examine(actionVo.getComment(),actionVo.getID());
        if (dbResult) return new Result(ResponseCode.OK);
        else return new Result(ResponseCode.DataBaseError);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: PledgeVo
     *@Return: Result
     *@Description: 金融机构草拟质押条件并签署合约
     */
    @RequestMapping(value = "/financeSign",method = RequestMethod.PUT)
    public Result financeSign(@RequestBody PledgeVo pledgeVo){
        boolean check=checkService.financeCheck(pledgeVo.getAccountName(),pledgeVo.getActionPassword(),12);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);
        Boolean dbResult=emissionService.financePledge(pledgeVo);
        if (dbResult) return new Result(ResponseCode.OK);
        else return new Result(ResponseCode.DataBaseError);
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ActionVo，ticketNum(可创建的碳信额度)
     *@Return: Result
     *@Description: 控排链企业决定是否答应金融机构的贷款条件
     */
    @RequestMapping(value = "/companySign",method = RequestMethod.PUT)
    public Result companySign(@RequestBody ActionVo actionVo, @RequestParam Integer ticketNum){
        ControlCore controlCore;
        ControlSub controlSub;
        if(Objects.equals(actionVo.getAccountType(), AccountType.ControlCore.getCode())){
            controlCore= userService.getCCAccount(actionVo.getAccountName());
            if(controlCore==null|| !Objects.equals(controlCore.getPledgeSigning(), actionVo.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方所在供应链碳信余额
            if(actionVo.getComment()&&!balanceService.pledgeAfterSign(controlCore.getControlChain(),ticketNum))
                return new Result(ResponseCode.DataBaseError);
        }
        else if(Objects.equals(actionVo.getAccountType(), AccountType.ControlSub.getCode())){
            controlSub=userService.getCSAccount(actionVo.getAccountName());
            if(controlSub==null|| !Objects.equals(controlSub.getPledgeSigning(), actionVo.getActionPassword()))
                return new Result(ResponseCode.InsufficientPermissions);
            //修改发行方所在供应链碳信余额
            if(actionVo.getComment()&&!balanceService.pledgeAfterSign(controlSub.getControlChain(),ticketNum))
                return new Result(ResponseCode.DataBaseError);
        }
        Boolean dbResult=emissionService.examine(actionVo.getComment(),actionVo.getID());
        if(!dbResult) return new Result(ResponseCode.DataBaseError);
        //BalanceService更改账户余额
        return new Result(ResponseCode.OK);
    }
}
