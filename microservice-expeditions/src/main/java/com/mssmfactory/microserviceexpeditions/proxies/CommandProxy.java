package com.mssmfactory.microserviceexpeditions.proxies;

import com.mssmfactory.microserviceexpeditions.model.Command;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RibbonClient(name = "command-microservice")
@FeignClient(name = "command-microservice")
public interface CommandProxy {

    @GetMapping("command/{id}")
    Optional<Command> findById(@PathVariable("id") Integer commandId);
}
