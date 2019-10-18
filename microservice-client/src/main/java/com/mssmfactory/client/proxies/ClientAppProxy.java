package com.mssmfactory.client.proxies;

import com.mssmfactory.client.model.Expedition;
import com.mssmfactory.client.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-microservice")
@RibbonClients({
        @RibbonClient("product-microservice"),
        @RibbonClient("expedition-microservice")
})
public interface ClientAppProxy {

    @GetMapping("product-microservice/product/products")
    List<Product> findAll();

    @GetMapping("product-microservice/product/{id}")
    Optional<Product> findProductById(@PathVariable("id") Integer id);

    @GetMapping("expedition-microservice/expedition/{id}")
    Optional<Expedition> findExpeditionById(@PathVariable("id") Integer expeditioId);
}
