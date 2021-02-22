package com.sanvalero.introrxjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private String title;
    private String description;
    private int pageCount;
    private String category;
    private LocalDate publicationDate;
}
