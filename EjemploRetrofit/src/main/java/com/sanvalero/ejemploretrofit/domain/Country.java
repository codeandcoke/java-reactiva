package com.sanvalero.ejemploretrofit.domain;

/**
 * Modelo de objeto que devuelve la API (https://restcountries.eu/)
 * @author Santiago Faci
 * @version curso 2020-2021
 */
public class Country {

    private String name;
    private String capital;
    private String region;
    private String subregion;

    @Override
    public String toString() {
        return name + " [" + capital +  "]";
    }
}
