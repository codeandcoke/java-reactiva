package com.sanvalero.ejemploretrofit.service;

import com.sanvalero.ejemploretrofit.domain.Country;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

/**
 * Interfaz de la API para emplear con RetroFit (https://restcountries.eu)
 * @author Santiago Faci
 * @version Curso 2020-2021
 */
public interface CountriesApiService {

    @GET("/rest/v2/all")
    Observable<List<Country>> getAllCountries();

    // Cuidado! Aunque la respuesta en un solo país viene en forma de array
    @GET("/rest/v2/name/{name}")
    Observable<List<Country>> getCountry(@Path("name") String name);
}
