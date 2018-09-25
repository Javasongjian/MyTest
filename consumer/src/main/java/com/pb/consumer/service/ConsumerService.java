package com.pb.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "songjianNBError")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://songjianNB/songjian/hello",String.class).getBody();
    }

    private String songjianNBError(){
        return "songjianNB have some error";
    }
}
