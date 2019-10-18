package com.mproducts.web.controller;

import com.mproducts.config.PropertiesHolder;
import com.mproducts.model.Product;
import com.mproducts.repositories.ProductRepository;
import com.mproducts.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PropertiesHolder propertiesHolder;

    @GetMapping("products")
    public List<Product> products() {
        List<Product> products = this.productRepository.findAll();

        if (products.isEmpty())
            throw new ProductNotFoundException("Not product is available for sale !");

        return products.subList(0, Math.min(products.size(), this.propertiesHolder.getProductsFetchSize()));
    }

    @GetMapping("{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {
        Optional<Product> product = this.productRepository.findById(id);

        if (!product.isPresent())
            throw new ProductNotFoundException("Th product " + id + " doesn't exist");

        return product;
    }
}

