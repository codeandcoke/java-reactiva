package com.sanvalero.myshopwebfluxclient.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class Product {

    private String id;
    private String name;
    private String description;
    private String category;
    private float price;
    private LocalDateTime creationDate;
}
