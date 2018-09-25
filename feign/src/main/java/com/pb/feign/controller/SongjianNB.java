package com.pb.feign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "songjianNB", fallback = SongjianNBImpl.class)
@Component
public interface SongjianNB {

    @RequestMapping(value = "/songjian/hello", method = RequestMethod.GET)
    String hello();

}

