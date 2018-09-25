package com.pb.feign.controller;


import org.springframework.stereotype.Component;

@Component
public class SongjianNBImpl implements SongjianNB {

    @Override
    public String hello() {
        return "songjianNB have some error";
    }
}
