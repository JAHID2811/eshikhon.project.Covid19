package com.eshikhon.project.covid19.model;

import com.google.gson.annotations.SerializedName;
import com.eshikhon.project.covid19.utils.NullRemoveUtil;

import java.util.List;

public class CountriesStatResponse {

    @SerializedName("countries_stat")
    private List<CountriesStat> countriesStat;

    public List<CountriesStat> getCountriesStat() {
        return NullRemoveUtil.getNotNull(countriesStat);
    }

}
