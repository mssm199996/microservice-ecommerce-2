package com.mssmfactory.client.controllers;

import com.mssmfactory.client.model.Expedition;
import com.mssmfactory.client.model.Product;
import com.mssmfactory.client.proxies.ClientAppProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientAppProxy clientAppProxy;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("products", this.clientAppProxy.findAll());

        return "home";
    }

    @RequestMapping("/product-details/{id}")
    public String productDetails(@PathVariable("id") Integer id, Model model) {
        Optional<Product> productOptional = this.clientAppProxy.findProductById(id);

        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());

            return "product_details";
        }

        return this.home(model);
    }

    @RequestMapping("/expedition-details/{id}")
    public String expeditionDetails(@PathVariable("id") Integer id, Model model) {
        Optional<Expedition> expeditionOptional = this.clientAppProxy.findExpeditionById(id);

        if (expeditionOptional.isPresent()) {
            model.addAttribute("expedition", expeditionOptional.get());

            return "expedition_details";
        }

        return this.home(model);
    }
}
