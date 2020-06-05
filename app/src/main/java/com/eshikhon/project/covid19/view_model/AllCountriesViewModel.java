package com.eshikhon.project.covid19.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.eshikhon.project.covid19.model.CountriesStatResponse;
import com.eshikhon.project.covid19.repository.AllCountriesRepository;

public class AllCountriesViewModel extends AndroidViewModel {
    private AllCountriesRepository allCountriesRepository;

    public AllCountriesViewModel(@NonNull Application application) {
        super(application);
        allCountriesRepository = new AllCountriesRepository(application);
    }

    public LiveData<CountriesStatResponse> getStateByCountryLiveData() {
        return allCountriesRepository.getCountriesStatResponseLiveData();
    }
}
