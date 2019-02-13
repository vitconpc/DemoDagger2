package com.example.myapplication.dagger2;

import com.example.myapplication.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = FoodModule.class)
@Singleton
public interface FoodComponent {
    void inject(MainActivity mainActivity);
}
