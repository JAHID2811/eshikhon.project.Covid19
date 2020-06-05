package com.eshikhon.project.covid19.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.eshikhon.project.covid19.model.CountryResponse;
import com.eshikhon.project.covid19.model.StateByCountryResponse;
import com.eshikhon.project.covid19.model.WorldStateResponse;
import com.eshikhon.project.covid19.repository.WorldStatRepository;

import java.util.List;

public class WorldStatViewModel extends AndroidViewModel {
    private WorldStatRepository worldStatRepository;

    public WorldStatViewModel(@NonNull Application application) {
        super(application);
        worldStatRepository = new WorldStatRepository(application);
    }

    public LiveData<List<CountryResponse>> getCountryLiveData() {
        return worldStatRepository.getCountryResponseLiveData();
    }

    public LiveData<WorldStateResponse> getWorldStateLiveData() {
        return worldStatRepository.getWorldStateLiveData();
    }

    public LiveData<StateByCountryResponse> getStateByCountryLiveData(String country) {
        return worldStatRepository.getStateByCountryLiveData(country);
    }
}
