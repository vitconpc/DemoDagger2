package com.example.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.common.adapter.FoodAdapter;
import com.example.myapplication.common.adapter.FoodAdapterCallback;
import com.example.myapplication.dagger2.DaggerFoodComponent;
import com.example.myapplication.dagger2.FoodModule;
import com.example.myapplication.presenter.FoodPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView, FoodAdapterCallback {

    @Inject
    FoodPresenter mFoodPresenter;
    @Inject
    FoodAdapter mFoodAdapter;
    private RecyclerView mRvFoods;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFoodPresenter.onResume();
    }

    private void initData() {
        DaggerFoodComponent.builder().foodModule(new FoodModule(this,this,this)).build().inject(this);
        mFoodAdapter.setFoods(mFoodPresenter.getFoods());
        mRvFoods.setLayoutManager(new LinearLayoutManager(this));
        mRvFoods.setAdapter(mFoodAdapter);
        mProgressBar.setVisibility(View.GONE);
    }

    private void initView() {
        mRvFoods = findViewById(R.id.rv_food);
        mProgressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void showData() {
        mFoodAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRvFoods.setVisibility(View.GONE);
    }

    @Override
    public void hideDialog() {
        mProgressBar.setVisibility(View.GONE);
        mRvFoods.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClick(int position) {
        mFoodPresenter.itemOnclick(position);
    }
}
