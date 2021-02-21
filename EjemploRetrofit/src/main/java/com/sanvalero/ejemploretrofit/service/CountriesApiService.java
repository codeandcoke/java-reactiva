package com.sanvalero.ejemploretrofit.service;

import com.sanvalero.ejemploretrofit.domain.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Interfaz de la API (https://restcountries.eu/)
 * @author Santiago Faci
 * @version curso 2020-2021
 */
public interface CountriesApiService {

    @GET("/rest/v2/all")
    Call<List<Country>> getAllCountries();

    // Cuidado! Aunque la respuesta en un solo país viene en forma de array
    @GET("/rest/v2/name/{name}")
    Call<List<Country>> getCountry(@Path("name") String name);
}
