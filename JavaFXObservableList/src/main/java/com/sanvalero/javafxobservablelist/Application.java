package com.sanvalero.javafxobservablelist;

import com.sanvalero.javafxobservablelist.domain.Cinema;
import com.sanvalero.javafxobservablelist.domain.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Application {
    public static void main(String[] args) {
        Movie movie = Movie.builder()
                .title("Rocky")
                .summary("Pelicula de boxeo")
                .duration(120)
                .build();
        Cinema cinema = Cinema.builder()
                .name("Cinema1")
                .build();
        ObservableList<Movie> movies = FXCollections.observableArrayList(movie);
        movies.addListener(cinema);

        movies.remove(0);
        movies.add(Movie.builder().title("Terminator 2").build());
    }
}
