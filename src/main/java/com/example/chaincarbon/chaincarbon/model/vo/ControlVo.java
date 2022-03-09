package com.example.chaincarbon.model.vo;

import lombok.Data;

@Data
public class ControlVo {
    String name;
    String chain;
    Integer carbonLimit;
    Integer TicketUnissued;
    Integer TicketBuyback;
    Integer EmisssionPledged;
}
