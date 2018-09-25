package com.pb.feign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/feign")
@RestController
public class FeignController {

    @Autowired
    SongjianNB songjianNB;

    @RequestMapping(value = "demo",method = RequestMethod.GET)
    public String index(){
        return songjianNB.hello();
    }
}

