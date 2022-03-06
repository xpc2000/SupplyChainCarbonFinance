package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.LoginVo;
import com.example.chaincarbon.testData.SysUser;
import com.example.chaincarbon.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class SysUserControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Test
    void login() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        SysUser sysUser=new SysUser();
//        sysUser.setUsername("zszxz");
//        sysUser.setPassword("zszxz");
//        String responseString=null;
//        RequestBuilder request = MockMvcRequestBuilders.post("https://127.0.0.1:8081/login")
//                .content(Objects.requireNonNull(JsonUtils.toJson(sysUser))).contentType(MediaType.APPLICATION_JSON);
//        try{
//            responseString=mvc.perform(request).andReturn().getResponse().getContentAsString();
//            System.out.println(responseString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        LoginVo loginVo =new LoginVo();
        loginVo.setUserEmail("xyzswasz@163.com");
        loginVo.setAccountType(0);
        loginVo.setPassword("123123");
        String responseString=null;
        RequestBuilder requestBuilder=MockMvcRequestBuilders.post("https://127.0.0.1:8081/user/login")
                .content(Objects.requireNonNull(JsonUtils.toJson(loginVo))).contentType("application/json;charset=UTF-8");
        try{
            responseString=mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(responseString);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void get() throws Exception {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDU1MzAyMjQsInVzZXJuYW1lIjoienN6eHoifQ.J6jmdsquzm76gO7C4CAiB5S67nUzRUkmD_AKUdxWjS8";
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = MockMvcRequestBuilders.get("https://127.0.0.1:8081/api/test").header("token",token);
        String responseString=null;
        responseString=mvc.perform(request).andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }


}