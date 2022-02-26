package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.LoginVo;
import com.example.chaincarbon.service.UserService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @Author: xpc2000
     * @Date: 2022/02/26
     * @Param: LoginVo
     * @Return: Result
     * @Description: 登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody LoginVo loginVo){
        Boolean checkResult= userService.loginCheck(loginVo.getUserEmail(),loginVo.getPassword());
        //成功返回账户信息，失败返回失败提示
        if (checkResult){
            //查找整理账户信息

            return new Result(ResponseCode.OK,new Object());
        }
        else{
            return new Result(ResponseCode.LoginFailure);
        }
    }


}
