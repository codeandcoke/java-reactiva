package com.sanvalero.javafxobservablelist.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class Movie {

    private String title;
    @EqualsAndHashCode.Exclude
    private String summary;
    @EqualsAndHashCode.Exclude
    private int duration;
}
