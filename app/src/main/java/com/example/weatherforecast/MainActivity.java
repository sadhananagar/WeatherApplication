package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherforecast.model.RecyclerList;

public class MainActivity extends AppCompatActivity {

    public String city_name;
    public String api="74fa9be197ed33543611c13b51008b9d";

    RecyclerViewAdapter recyclerViewAdapter;
    private MainActivityViewModel viewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.textView_city);

        Intent i= getIntent();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            city_name= (String) bundle.get("city_name");
        }
        textView.setText("DISPLAYING: "+city_name);


        initRecyclerView();
        getData();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter= new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void getData(){
        viewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getRecyclerListObserver().observe(this, new Observer<RecyclerList>() {
            @Override
            public void onChanged(RecyclerList recyclerList) {
                if(recyclerList!= null){
                    recyclerViewAdapter.setListData(recyclerList.getItems());
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                else
                    {
                    Toast.makeText(MainActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.makeApiCall(city_name,api);
    }
}