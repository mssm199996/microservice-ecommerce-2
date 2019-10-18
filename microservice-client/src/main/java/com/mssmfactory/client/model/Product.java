package com.mssmfactory.client.model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String title, description, image;
    private Double price;
}
