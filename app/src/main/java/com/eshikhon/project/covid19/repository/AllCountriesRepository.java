package com.eshikhon.project.covid19.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eshikhon.project.covid19.api.ApiClient;
import com.eshikhon.project.covid19.model.CountriesStatResponse;
import com.eshikhon.project.covid19.utils.AppConstant;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class AllCountriesRepository {
    private MutableLiveData<CountriesStatResponse> countriesStatLiveData = new MutableLiveData<>();
    private Context context;

    public AllCountriesRepository(Context context) {
        ApiClient.getApiService();
        this.context = context;
    }

    public LiveData<CountriesStatResponse> getCountriesStatResponseLiveData() {

        ApiClient.getApiService().getAllCountriesResponse().enqueue(new Callback<CountriesStatResponse>() {
            @Override
            public void onResponse(@NotNull Call<CountriesStatResponse> call, @NotNull Response<CountriesStatResponse> response) {

                if (response.isSuccessful()) {

                    Timber.e("Success State By All Country Response");

                    CountriesStatResponse countriesStatResponse = response.body();

                    if (countriesStatResponse != null) {

                        countriesStatLiveData.setValue(countriesStatResponse);
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<CountriesStatResponse> call, @NotNull Throwable t) {
                Timber.e("%s%s", AppConstant.ERROR, t.getMessage());

            }
        });

        return countriesStatLiveData;
    }
}
