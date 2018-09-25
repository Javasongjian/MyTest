package com.pb.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

//@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
//        System.out.println(accessToken);
        if(accessToken == null){
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("I am handsome and blame me.");
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
