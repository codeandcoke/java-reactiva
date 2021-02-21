package com.sanvalero.ejemploretrofit;

import com.sanvalero.ejemploretrofit.service.CountriesService;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executors;

/**
 * Clase principal
 * @author Santiago Faci
 * @version curso 2020-2021
 */
public class Application {
    public static void main(String[] args) {
        final CountriesService countriesService = new CountriesService();

        System.out.println("Comenzando descarga . . .");

        countriesService.getAllCountries()
                .flatMap(Observable::from)
                .doOnCompleted(() -> System.out.println("Listado de países descargado"))
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .subscribe(System.out::println);

        countriesService.getCountry("spain")
                .doOnCompleted(() -> System.out.println("Cargada información de spain"))
                .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
                .subscribe(System.out::println);

        System.out.println("Fin?");
    }
}
