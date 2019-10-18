package com.mproducts.config;

import com.mproducts.model.Product;
import com.mproducts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class InitialDataConfig {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initIntialData() {
        if (this.productRepository.count() == 0L) {
            List<Product> products = new LinkedList<>();
            products.add(new Product(0, "Bougie fonctionnant au feu", "bougie qui fonctionne comme une ampoule mais sans électricité !",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/bougies.jpg", 22.0));
            products.add(new Product(1, "Chaise pour s'assoire", "Chaise rare avec non pas 1 ni 2 mais 3 pieds",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/chaise.jpg", 95.0));
            products.add(new Product(2, "Cheval pour nains", "Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/cheval.jpg", 360.0));
            products.add(new Product(3, "Coq of steel, le superman des volailles", "Ne passe pas au four",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/coq.jpg", 620.0));
            products.add(new Product(4, "Flacon à frotter avec un génie dedans", "Vous donne droit à l'équivalent de 3/0 voeux",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/flacon.jpg", 1200.0));
            products.add(new Product(5, "Horloge quantique", "Donne l'heure, les minutes et même les secondes. Ne fait pas de café'",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/horloge.jpg", 180.0));
            products.add(new Product(6, "Table d''opération pour Hamsters", "Pour réaliser vos opérations chirugicales sur votre Hamster!",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/table.jpg", 210.0));
            products.add(new Product(7, "Vase ayant appartenu a Zeus", "Risque de choc électrique",
                    "https://s3.eu-west-3.amazonaws.com/oc-images-cours/vase.jpg", 730.0));

            this.productRepository.saveAll(products);
        }
    }
}
