package com.sanvalero.myshop.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(value = "products")
public class Product {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String description;
    @Field
    private String category;
    @Field
    private float price;
    @Field(name = "creation_date")
    private LocalDateTime creationDate;
}
