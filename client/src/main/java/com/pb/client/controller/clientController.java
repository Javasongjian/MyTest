package com.pb.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/songjian")
@RestController
public class clientController {

    private final Logger logger = LoggerFactory.getLogger(clientController.class);

    @Autowired
    private DiscoveryClient client;



    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        StringBuilder sb = new StringBuilder();
        List<String> serviceIds = client.getServices();
        if(!CollectionUtils.isEmpty(serviceIds)){
            for(String s:serviceIds){
                logger.info("宋健serviceId:"+s);
                List<ServiceInstance> serviceInstances = client.getInstances(s);
                if(!CollectionUtils.isEmpty(serviceInstances)){
                    for(ServiceInstance serviceInstance:serviceInstances){
                        sb.append("["+serviceInstance.getServiceId()+" host:"+serviceInstance.getHost()+" port:"+serviceInstance.getPort()+" Uri"+serviceInstance.getUri()+"]");
                        logger.info("宋健"+sb.toString());
                    }
                }else{
                    sb.append("no service");
                }
            }
        }

        return "client"+sb.toString();
    }
}
