package com.example.chaincarbon;

import com.example.chaincarbon.model.vo.*;
import com.example.chaincarbon.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class ChainCarbonApplicationTests {
    @Resource
    private MockMvc mockMvc;

//    private List<String> testSearch = Arrays.asList(
//            "/ticketSearch/8",
//            "/ticketSearch/pending?chain=智能碳核算系统&company=绿色管家有限公司",
//            "/ticketSearch/signed?chain=智能碳核算系统&company=绿色管家有限公司",
//            "/ticketSearch/canceled?chain=智能碳核算系统&company=绿色管家有限公司",
//            "/ticketSearch/reject?chain=智能碳核算系统&company=绿色管家有限公司",
//            "/pledgeSerach/4",
//            "/pledgeSerach/submit?chain=阳光牌大理石瓷砖&company=光大石材工程有限公司",
//            "/pledgeSerach/signing-company?chain=阳光牌大理石瓷砖&company=光大石材工程有限公司",
//            "/pledgeSerach/pending?company=阳光建材有限公司",
//            "/pledgeSerach/signing-institution?company=阳光建材有限公司",
//            "/factorSearch/1",
//            "/factorSearch/applying?company=光大石材工程有限公司",
//            "/factorSearch/signing-company?company=光大石材工程有限公司",
//            "/factorSearch/pending?company=中信实业银行",
//            "/factorSearch/approved?company=中信实业银行"
//    );
//    private List<String> testControl = Arrays.asList(
//            "/chain/plan"
//    );
//    private List<Object> testControlParam = Arrays.asList(
//      new PlanVo("阳光建材有限公司",null,"12345","阳光牌大理石瓷砖",null,2,3,"2022-3-15 00:12:00")
//    );
//    private List<String> testEmission = Arrays.asList(
//            "/pledge/apply",
//            "/pledge/examine",
//            "/pledge/financeSign",
//            "/pledge/companySign?ticketNum=100007"
//    );
//    private List<Object> testEmissionParam = Arrays.asList(
//            new ApplyPledgeVo("光大石材工程有限公司",2,"2334df","阳光牌大理石瓷砖","光大石材工程有限公司","中信实业银行",100,null),
//            new ActionVo("中信实业银行",11,"12312",10,true),
//            new PledgeVo("中信实业银行",12,"123123",10,"阳光牌大理石瓷砖","光大石材工程有限公司","中信实业银行",10,1002, (float) 0.1, (float) 0.2,"2022-03-09 00:00:00","2022-04-22 00:00:00",null),
//            new ActionVo("光大石材工程有限公司",2,"45634",10,true)
//    );
//    private List<String> testFund = Arrays.asList(
//            "/fund/apply",
//            "/fund/examine",
//            "/fund/financeSign",
//            "/fund/companySign?ticketNum=10"
//    );
//    private List<Object> testFundParam = Arrays.asList(
//            new ApplyFactorVo("云石物联网有限公司",4,"23435","云石物联网有限公司","中信实业银行",100,"中信实业银行","中信实业银行",null),
//            new ActionVo("中信实业银行",21,"123123",6,true),
//            new FactorVo("中信实业银行",22,"1233123","云石物联网有限公司","中信实业银行",1000,"中信实业银行","2022-03-09 00:00:00","中信实业银行",6,1000, (float) 0.1, (float) 0.2,"2022-04-22 00:00:00",null),
//            new ActionVo("云石物联网有限公司",4,"12345",6,true)
//    );
//    private List<String> testTicket = Arrays.asList(
//            "/ticket/create",
//            "/ticket/publish",
//            "/ticket/publishCheck?ticketNum=10",
//            "/ticket/transfer",
//            "/ticket/transferCheck?ticketNum=10",
//            "/ticket/buyback",
//            "/ticket/destroy"
//    );
//    private List<Object> testTicketParam = Arrays.asList(
//            new TicketVo("阳光建材有限公司",1,"12345","阳光牌大理石瓷砖","阳光建材有限公司","智能碳核算系统","绿色管家有限公司",10,null),
//            new TicketVo("阳光建材有限公司",1,"12345","阳光牌大理石瓷砖","阳光建材有限公司","智能碳核算系统","绿色管家有限公司",10,null),
//            new ActionVo("绿色管家有限公司",3,"12455",11,true),
//            new TicketVo("绿色管家有限公司",3,"12355","智能碳核算系统","绿色管家有限公司","智能碳核算系统","云石物联网有限公司",10,null),
//            new ActionVo("云石物联网有限公司",2,"666",11,true),
//            new TicketVo("阳光建材有限公司",1,"12345","阳光牌大理石瓷砖","阳光建材有限公司","智能碳核算系统","绿色管家有限公司",10,null),
//            new TicketVo("阳光建材有限公司",1,"12345","阳光牌大理石瓷砖","阳光建材有限公司","智能碳核算系统","绿色管家有限公司",10,null)
//    );
//    private List<String> testUser = Arrays.asList(
//            "/user/login"
//    );
//    private List<Object> testUserParam = Arrays.asList(
//            new LoginVo("xyzswasz@163.com",0,"123123"),
//            new LoginVo("123456us78@163.com",1,"12345"),
//            new LoginVo("qwewcadad@163.com",2,"23456"),
//            new LoginVo("zdsafa@163.com",3,"12355"),
//            new LoginVo("nadfaf@163.com",4,"666")
//    );

    @Test
    void contextLoads() {
        Integer count = 1;
        try {
            /*for(String item:testSearch){
                System.out.println("Test "+count);
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,item)).andDo(MockMvcResultHandlers.print());
                count++;
            }*/
            /*for(int i = 0;i < testControl.size();i++){
                System.out.println("Test "+count);
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,testControl.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testControlParam.get(i)))).andDo(MockMvcResultHandlers.print());
                count++;
            }*/
            /*for(int i=0;i<testEmission.size();i++){
                System.out.println("Test "+count);
                if(i==0){
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,testEmission.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testEmissionParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                else{
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.PUT,testEmission.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testEmissionParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                count++;
            }*/
            /*for(int i=0;i<testFund.size();i++){
                System.out.println("Test "+count);
                if(i==0){
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,testFund.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testFundParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                else{
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.PUT,testFund.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testFundParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                count++;
            }*/
            /*for(int i=0;i<testTicket.size();i++){
                System.out.println("Test "+count);
                if(i==2||i==4){
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.PUT,testTicket.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testTicketParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                else{
                    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,testTicket.get(i)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testTicketParam.get(i)))).andDo(MockMvcResultHandlers.print());
                }
                count++;
            }*/
            /*for (int i=0;i<testUserParam.size();i++){
                System.out.println("Test "+count);
                mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,testUser.get(0)).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(testUserParam.get(i)))).andDo(MockMvcResultHandlers.print());
                count++;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
