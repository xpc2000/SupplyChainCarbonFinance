package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.ActionVo;
import com.example.chaincarbon.model.vo.ApplyPledgeVo;
import com.example.chaincarbon.model.vo.PledgeVo;
import com.example.chaincarbon.service.CheckService;
import com.example.chaincarbon.service.EmissionService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ApplyPledgeVo
     *@Return: Result
     *@Description:
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(@RequestBody ApplyPledgeVo applyPledgeVo){
        Boolean check=checkService.controlCheck(applyPledgeVo.getAccountName(),applyPledgeVo.getActionPassword(),10,applyPledgeVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);

        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ActionVo
     *@Return: Result
     *@Description:
     */
    @RequestMapping(value = "/examine",method = RequestMethod.PUT)
    public Result examine(@RequestBody ActionVo actionVo){
        Boolean check=checkService.financeCheck(actionVo.getAccountName(),actionVo.getActionPassword(),11);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);

        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: PledgeVo
     *@Return: Result
     *@Description:
     */
    @RequestMapping(value = "/financeSign",method = RequestMethod.PUT)
    public Result financeSign(@RequestBody PledgeVo pledgeVo){
        Boolean check=checkService.financeCheck(pledgeVo.getAccountName(),pledgeVo.getActionPassword(),12);
        if(!check) return new Result(ResponseCode.InsufficientPermissions);

        return new Result();
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/2/26
      *@Param: ActionVo
     *@Return: Result
     *@Description:
     */
    @RequestMapping(value = "/companySign",method = RequestMethod.PUT)
    public Result companySign(@RequestBody ActionVo actionVo){
        Boolean check=checkService.controlCheck(actionVo.getAccountName(),actionVo.getActionPassword(),13,actionVo.getAccountType());
        if(!check) return new Result(ResponseCode.InsufficientPermissions);

        return new Result();
    }
}
