package com.example.chaincarbon.service;

import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    public Boolean create(String publisher, Integer num){
        return false;
    }

    public Boolean publish(String sender,String receiver,Integer num){
        return false;
    }

    public Boolean transfer(String sender,String receiver,Integer num){
        return false;
    }

    public Boolean buyback(String publisher, Integer num){
        return false;
    }

    public Boolean destroy(String chain){
        return false;
    }
}
