package com.example.chaincarbon.test;

import com.example.chaincarbon.testData.SysUser;
import com.example.chaincarbon.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SysUserController {
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody SysUser sysUser){
        Map<String, Object> map = new HashMap<>();
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        // 省略 账号密码验证
        // 验证成功后发送token
        String token = JwtUtil.sign(username,password);
        if (token != null){
            map.put("code", "200");
            map.put("message","认证成功");
            map.put("token", token);
            return map;
        }
        map.put("code", "403");
        map.put("message","认证失败");
        return map;
    }

    @GetMapping(value = "/api/test")
    public String get(){
        return "为什么？";
    }
}
