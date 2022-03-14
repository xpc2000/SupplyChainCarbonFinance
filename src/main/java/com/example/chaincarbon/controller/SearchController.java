package com.example.chaincarbon.controller;

import com.example.chaincarbon.model.vo.TransferTicketVo;
import com.example.chaincarbon.service.EmissionService;
import com.example.chaincarbon.service.FundingService;
import com.example.chaincarbon.service.TicketService;
import com.example.chaincarbon.utils.ResponseCode;
import com.example.chaincarbon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Component
public class SearchController {
    @Autowired
    TicketService ticketService;
    @Autowired
    EmissionService emissionService;
    @Autowired
    FundingService fundingService;


    /**
     * @Author:周文峰
     * @Date:2022/3/1
     * @Description:获取碳信记录
     */
    @RestController
    @RequestMapping(value = "/ticketSearch")
    class SearchTicket{
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:记录id
         * @Description:获取特定碳信记录
         */
        @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getTicketRecord(@PathVariable Integer id){
            return new Result(ResponseCode.OK, ticketService.getTicketRecord(id));
        }

        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属减排链，企业名称
         * @Description:获取企业需要签收的碳信记录
         */
        @RequestMapping(value = "/pending",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getPendingTicketRecords(@RequestParam String chain, @RequestParam String company){
            List<TransferTicketVo> list=ticketService.getTicketRecords(chain,company,0,0,Arrays.asList(1,2,3,4,5,6));
            Result result=new Result(ResponseCode.OK,list);
            return result;
//            return new Result(ResponseCode.OK, ticketService.getTicketRecords(chain,company,0,0,Arrays.asList(1,2,3,4,5,6)));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:企业所属减排链，企业名称
//         * @Description:获取企业需要签收的碳信记录
//         */
//        @RequestMapping(value = "/pending",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
//        public Result getPendingTicketRecords(@RequestParam String chain, @RequestParam String company){
//            return new Result(ResponseCode.OK, ticketService.getTicketRecords(chain,company,0,0,Arrays.asList(1,2,3,4,5,6)));
//        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属减排链，企业名称
         * @Description:获取企业已经签收的碳信记录
         */
        @RequestMapping(value = "/signed",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getSignedTicketRecords(@RequestParam String chain, @RequestParam String company){
            return new Result(ResponseCode.OK, ticketService.getTicketRecords(chain,company,4,0,Arrays.asList(2,3)));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属减排链，企业名称
         * @Description:获取企业被对方取消的碳信记录
         */
        @RequestMapping(value = "/canceled",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getCanceledTicketRecords(@RequestParam String chain, @RequestParam String company){
            return new Result(ResponseCode.OK, ticketService.getTicketRecords(chain,company,1,0,Arrays.asList(2,3)));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属减排链，企业名称
         * @Description:获取企业已经拒收的碳信记录
         */
        @RequestMapping(value = "/reject",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getRejectTicketRecords(@RequestParam String chain, @RequestParam String company){
            return new Result(ResponseCode.OK, ticketService.getTicketRecords(chain,company,2,0,Arrays.asList(2,3)));
        }
    }


    /**
     * @Author:周文峰
     * @Date:2022/3/1
     * @Description:获取碳质押记录
     */
    @RestController
    @RequestMapping(value = "/pledgeSearch")
    class SearchPledge{
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:记录id
         * @Description:获取特定碳质押记录
         */
        @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getPledgeRecord(@PathVariable Integer id){
            return new Result(ResponseCode.OK, emissionService.getPledgeRecord(id));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属控排链，企业名称
         * @Description:获取企业已经提交的碳质押记录
         */
        @RequestMapping(value = "/submit",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getSubmitPledge(@RequestParam String chain, @RequestParam String company){
            return new Result(ResponseCode.OK, emissionService.getCompanyPledgeRecords(chain,company,0));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:企业所属控排链，企业名称
//         * @Description:获取企业已经审批的碳质押记录
//         */
//        @RequestMapping(value = "/approved",method = RequestMethod.GET)
//        public Result getApprovedPledge(@RequestParam String chain, @RequestParam String company){
//            return new Result(ResponseCode.OK, emissionService.getCompanyPledgeRecords(chain,company,1));
//        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业所属控排链，企业名称
         * @Description:获取企业可以签约的碳质押记录
         */
        @RequestMapping(value = "/signing-company",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getCompanySignedPledge(@RequestParam String chain, @RequestParam String company){
            return new Result(ResponseCode.OK, emissionService.getCompanyPledgeRecords(chain,company,2));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:金融机构名称
         * @Description:获取金融机构待审批的碳质押记录
         */
        @RequestMapping(value = "/pending",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getPendingPledge(@RequestParam String company){
            return new Result(ResponseCode.OK, emissionService.getInstitutionPledgeRecords(company,0));
        }

        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:金融机构名称
         * @Description:获取金融机构需要签约的碳质押记录
         */
        @RequestMapping(value = "/signing-institution",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getSigningPledge(@RequestParam String company){
            return new Result(ResponseCode.OK, emissionService.getInstitutionPledgeRecords(company,1));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:金融机构名称
//         * @Description:获取金融机构已经签约的碳质押记录
//         */
//        @RequestMapping(value = "/signed-institution",method = RequestMethod.GET)
//        public Result getInstitutionSignedPledge(@RequestParam String company){
//            return new Result(ResponseCode.OK, emissionService.getInstitutionPledgeRecords(company,2));
//        }
    }


    /**
     * @Author:周文峰
     * @Date:2022/3/1
     * @Description:获取融资记录
     */
    @RestController
    @RequestMapping(value = "/factorSearch")
    class SearchFactor{
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:记录id
         * @Description:获取特定融资记录
         */
        @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getFactorRecord(@PathVariable Integer id){
            return new Result(ResponseCode.OK, fundingService.getFactorRecord(id));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业名称
         * @Description:获取企业申请中的融资记录
         */
        @RequestMapping(value = "/applying",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getApplyingFactorRecord(@RequestParam String company){
            return new Result(ResponseCode.OK, fundingService.getCompanyFactorRecords(company,0));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:企业名称
//         * @Description:获取企业通过审核的融资记录
//         */
//        @RequestMapping(value = "/pass",method = RequestMethod.GET)
//        public Result getPassFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getCompanyFactorRecords(company,1));
//        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:企业名称
         * @Description:获取企业可签约的融资记录
         */
        @RequestMapping(value = "/signing-company",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getCompanySigningFactorRecord(@RequestParam String company){
            return new Result(ResponseCode.OK, fundingService.getCompanyFactorRecords(company,2));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:企业名称
//         * @Description:获取企业已经签约的融资记录
//         */
//        @RequestMapping(value = "/signed-company",method = RequestMethod.GET)
//        public Result getCompanySignedFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getCompanyFactorRecords(company,3));
//        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:企业名称
//         * @Description:获取企业申请失败的融资记录
//         */
//        @RequestMapping(value = "/failed-company",method = RequestMethod.GET)
//        public Result getCompanyFailedFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getCompanyFactorRecords(company,4));
//        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:金融机构名称
         * @Description:获取金融机构待审批的融资记录
         */
        @RequestMapping(value = "/pending",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getPendingFactorRecord(@RequestParam String company){
            return new Result(ResponseCode.OK, fundingService.getInstitutionFactorRecords(company,0));
        }
        /**
         * @Author:周文峰
         * @Date:2022/3/1
         * @Param:金融机构名称
         * @Description:获取金融机构已审批的融资记录
         */
        @RequestMapping(value = "/approved",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
        public Result getApprovedFactorRecord(@RequestParam String company){
            return new Result(ResponseCode.OK, fundingService.getInstitutionFactorRecords(company,1));
        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:金融机构名称
//         * @Description:获取金融机构待签约的融资记录
//         */
//        @RequestMapping(value = "/signing-institution",method = RequestMethod.GET)
//        public Result getInstitutionSigningFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getInstitutionFactorRecords(company,2));
//        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:金融机构名称
//         * @Description:获取金融机构已经签约的融资记录
//         */
//        @RequestMapping(value = "/signed-institution",method = RequestMethod.GET)
//        public Result getInstitutionSignedFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getInstitutionFactorRecords(company,3));
//        }
//        /**
//         * @Author:周文峰
//         * @Date:2022/3/1
//         * @Param:金融机构名称
//         * @Description:获取金融机构签约失败的融资记录
//         */
//        @RequestMapping(value = "/failed-institution",method = RequestMethod.GET)
//        public Result getInstitutionFailedFactorRecord(@RequestParam String company){
//            return new Result(ResponseCode.OK, fundingService.getInstitutionFactorRecords(company,4));
//        }
    }
}