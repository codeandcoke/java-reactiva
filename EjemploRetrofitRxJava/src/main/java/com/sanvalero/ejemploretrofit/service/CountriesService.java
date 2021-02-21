package com.sanvalero.ejemploretrofit.service;

import com.sanvalero.ejemploretrofit.domain.Country;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.util.List;

import static com.sanvalero.ejemploretrofit.util.Constants.URL;

/**
 * Service para consulta de la API
 * @author Santiago Faci
 * @version Curso 2020-2021
 */
public class CountriesService {

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(CountriesApiService.class);
    }

    public Observable<List<Country>> getAllCountries() {
        return api.getAllCountries();
    }

    public Observable<Country> getCountry(String name) {
        return api.getCountry(name).flatMapIterable(x -> x);
    }
}
