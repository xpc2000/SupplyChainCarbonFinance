package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class PledgeForCompanyVo {
    /**
     * @Author:周文峰
     * @Date:2022/3/1
     */
    private Integer id;
    private String institution;
    private Integer amount;
    private Integer status;
}