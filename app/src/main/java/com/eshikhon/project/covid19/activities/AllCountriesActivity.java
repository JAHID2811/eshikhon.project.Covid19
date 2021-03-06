package com.eshikhon.project.covid19.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eshikhon.project.covid19.R;
import com.eshikhon.project.covid19.adapter.AdapterAllCountriesState;
import com.eshikhon.project.covid19.model.CountriesStat;
import com.eshikhon.project.covid19.model.CountriesStatResponse;
import com.eshikhon.project.covid19.view_model.AllCountriesViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class AllCountriesActivity extends AppCompatActivity {

    @BindView(R.id.et_search)
    EditText etSearch;

    @BindView(R.id.rv_all_countries)
    RecyclerView rvAllCountries;

    private AdapterAllCountriesState adapterAllCountriesState;
    private AllCountriesViewModel allCountriesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_all_countries);
        ButterKnife.bind(this);

        allCountriesViewModel = ViewModelProviders.of(this).get(AllCountriesViewModel.class);


        allCountriesViewModel.getStateByCountryLiveData().observe(this, new Observer<CountriesStatResponse>() {
            @Override
            public void onChanged(CountriesStatResponse countriesStatResponse) {
                setCountryData(countriesStatResponse);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapterAllCountriesState.getFilter().filter(s.toString());
                //searchCountry(s.toString());
                Timber.e("AfterText: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setCountryData(CountriesStatResponse countriesStatResponse) {
        ArrayList<CountriesStat> countriesStatArrayList = (ArrayList<CountriesStat>) countriesStatResponse.getCountriesStat();
        adapterAllCountriesState = new AdapterAllCountriesState(this);
        adapterAllCountriesState.setCountriesStatArrayList(countriesStatArrayList);
        rvAllCountries.setLayoutManager(new LinearLayoutManager(this));
        rvAllCountries.setAdapter(adapterAllCountriesState);
    }
}
