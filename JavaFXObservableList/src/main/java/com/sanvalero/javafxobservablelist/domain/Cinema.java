package com.sanvalero.javafxobservablelist.domain;

import javafx.collections.ListChangeListener;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
public class Cinema implements ListChangeListener<Movie> {

    private String name;
    @EqualsAndHashCode.Exclude
    private String address;

    @Override
    public void onChanged(Change<? extends Movie> change) {
        while (change.next()) {
            if (change.wasRemoved()) {
                System.out.println("Se ha eliminado una pelicula: " + change.getRemoved().get(0));
            } else if (change.wasAdded()) {
                System.out.println("Se estrena una nueva pelicula: " + change.getAddedSubList().get(0));
            }
        }
    }
}
