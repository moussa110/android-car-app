package com.example.carapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.example.carapp.R;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    RecyclerView recyclerView;
    CarRecyclerAdapter adapter;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        adapter = new CarRecyclerAdapter();
        adapter.viewModel = viewModel;
        initViews();
        subscribeToLiveData();
        initListeners();
    }

    private void initListeners() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.getCars(1); // your code
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        refreshLayout = findViewById(R.id.swipeToRefresh);
        recyclerView.setAdapter(adapter);
    }

    private void subscribeToLiveData() {
        viewModel.getCarsLiveData().observe(this ,resource ->{
            switch (resource.getStatus()){
                case SUCCESS:{
                    adapter.changeData(resource.getData());
                }
                case ERROR:{
                    Toast.makeText(this,resource.getMessage(),Toast.LENGTH_LONG);
                }
            }
        });
    }
}