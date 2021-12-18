package com.example.weatherforecast;

import static android.content.Context.MODE_PRIVATE;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherforecast.di.RetroServiceInterface;
import com.example.weatherforecast.model.RecyclerList;

import java.net.URISyntaxException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    @Inject
    RetroServiceInterface mService;

//   public String city_name="london";
//private String api="74fa9be197ed33543611c13b51008b9d";

    private MutableLiveData<RecyclerList> liveDataList;

    public MainActivityViewModel(@NonNull Application application){
        super(application);
        ((MyApplication)application).getRetroComponent().inject(MainActivityViewModel.this);
        liveDataList= new MutableLiveData<>();
        }

    public MutableLiveData<RecyclerList> getRecyclerListObserver() {
        return liveDataList;
    }

    public void makeApiCall(String city_name, String api){

        Call<RecyclerList> call= mService.getDataFromAPI(city_name, api);
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()){
                    liveDataList.postValue(response.body());
                }else {
                    liveDataList.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveDataList.postValue(null);
            }
        });
    }
}
