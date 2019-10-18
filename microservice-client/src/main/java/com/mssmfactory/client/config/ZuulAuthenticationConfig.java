package com.mssmfactory.client.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.stereotype.Component;

@Component
public class ZuulAuthenticationConfig extends BasicAuthRequestInterceptor {

    public ZuulAuthenticationConfig() {
        super("root", "mssm1996");
    }
}
