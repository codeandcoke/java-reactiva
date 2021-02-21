package com.sanvalero.ejemploretrofit;

import com.sanvalero.ejemploretrofit.domain.Country;
import com.sanvalero.ejemploretrofit.service.CountriesService;

import java.util.List;

/**
 * Clase principal
 * @author Santiago Faci
 * @version curso 2020-2021
 */
public class Application {
    public static void main(String[] args) {
        CountriesService countriesService = new CountriesService();
        List<Country> countries = countriesService.getAllCountries();

        System.out.println(countries.toString());
    }
}
