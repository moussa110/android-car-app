package com.example.carapp.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carapp.api.ApiManager;
import com.example.carapp.api.resource.Resource;
import com.example.carapp.pojo.CarItem;
import com.example.carapp.pojo.CarResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Resource<List<CarItem>>> carsLiveData = new MutableLiveData<>();
    private List<CarItem> data = new ArrayList<CarItem>();

    public MutableLiveData<Resource<List<CarItem>>> getCarsLiveData() {
        return carsLiveData;
    }

    public MainActivityViewModel() {
        getCars(1);
    }

    public void getCars(int page) {
        //loading
        carsLiveData.setValue(Resource.loading());

        ApiManager.getApiService().getCars(page).enqueue(new Callback<CarResponse>() {
            @Override
            public void onResponse(Call<CarResponse> call, Response<CarResponse> response) {
                if (response.isSuccessful()) {
                    //success
                   for (int i =0;i< response.body().getData().size() ;i++){
                       data.add(response.body().getData().get(i));
                   }
                    carsLiveData.setValue(Resource.success(data));
                }else {
                    //error
                    carsLiveData.setValue(Resource.error(response.message()));
                }
            }

            @Override
            public void onFailure(Call<CarResponse> call, Throwable t) {
                //error
                carsLiveData.setValue(Resource.error(t.getMessage()));
            }
        });
    }
}
