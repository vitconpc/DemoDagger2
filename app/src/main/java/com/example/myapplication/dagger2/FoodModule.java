package com.example.myapplication.dagger2;

import android.content.Context;

import com.example.myapplication.common.adapter.FoodAdapter;
import com.example.myapplication.common.adapter.FoodAdapterCallback;
import com.example.myapplication.presenter.FoodPresenter;
import com.example.myapplication.presenter.FoodPresenterImpl;
import com.example.myapplication.view.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FoodModule {

    private Context mContext;
    private MainView mMainView;
    private FoodAdapterCallback mFoodAdapterCallback;

    public FoodModule(Context context, MainView mainView, FoodAdapterCallback foodAdapterCallback) {
        mContext = context;
        mMainView = mainView;
        mFoodAdapterCallback = foodAdapterCallback;
    }

    @Provides
    @Singleton
    FoodPresenter provideFoodPresenter(){
        return new FoodPresenterImpl(mContext,mMainView);
    }

    @Provides
    @Singleton
    FoodAdapter provideFoodAdapter(){
        return new FoodAdapter(mFoodAdapterCallback,mContext);
    }
}
