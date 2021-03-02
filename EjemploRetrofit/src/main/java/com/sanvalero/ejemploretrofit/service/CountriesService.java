package com.sanvalero.ejemploretrofit.service;

import com.sanvalero.ejemploretrofit.domain.Country;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.sanvalero.ejemploretrofit.util.Constants.URL;

/**
 * Service con las operaciones disponibles
 * @author Santiago Faci
 * @version curso 2020-2021
 */
public class CountriesService {

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(CountriesApiService.class);
    }

    public List<Country> getAllCountries() {
        Call<List<Country>> allCountriesCall = api.getAllCountries();
        try {
            Response<List<Country>> response = allCountriesCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

    // TODO Implementar el método que muestra la información de un país determinado
}
