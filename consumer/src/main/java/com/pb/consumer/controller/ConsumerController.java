package com.pb.consumer.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pb.consumer.service.ConsumerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ribbon")
public class ConsumerController {

    @Resource
    ConsumerService consumerService;


    @RequestMapping(value = "/consumer",method = RequestMethod.GET)
    private String helloConsumer(){

        return consumerService.helloConsumer();
    }


}
