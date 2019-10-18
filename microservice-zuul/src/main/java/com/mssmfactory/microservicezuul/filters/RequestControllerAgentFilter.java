package com.mssmfactory.microservicezuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestControllerAgentFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(RequestControllerAgentFilter.class);

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
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();

        this.logger.info("Receiving request from url: " + httpServletRequest.getRequestURL());
        this.logger.info("Client's local: " + httpServletRequest.getLocale());

        return null;
    }
}
