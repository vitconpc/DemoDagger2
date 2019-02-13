package com.example.myapplication.presenter;

import com.example.myapplication.model.Food;

import java.util.List;

public interface FoodPresenter {
    void onResume();

    void itemOnclick(int position);

    List<Food> getFoods();
}
