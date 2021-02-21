package com.sanvalero.ejemploretrofit.domain;

import lombok.Data;

/**
 * Country
 * @author Santiago Faci
 * @version Curso 2020-2021
 */
@Data
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
