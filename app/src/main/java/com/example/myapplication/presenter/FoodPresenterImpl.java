package com.example.myapplication.presenter;

import android.content.Context;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.interactor.FoodInteractor;
import com.example.myapplication.interactor.FoodInteractorCallBack;
import com.example.myapplication.interactor.FoodInteractorImpl;
import com.example.myapplication.model.Food;
import com.example.myapplication.view.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FoodPresenterImpl implements FoodPresenter, FoodInteractorCallBack {

    private Context mContext;
    private List<Food> mFoods;
    private MainView mMainView;
    private FoodInteractor mInteractor;

    public List<Food> getFoods() {
        return mFoods;
    }

    @Inject
    public FoodPresenterImpl(Context context, MainView mainView) {
        mContext = context;
        mFoods = new ArrayList<>();
        mMainView = mainView;
        mInteractor = new FoodInteractorImpl(mContext,this);
    }

    @Override
    public void onResume() {
        mMainView.showDialog();
        mInteractor.getData();
    }


    @Override
    public void itemOnclick(int position) {
        mMainView.showMessage(mFoods.get(position).getName());
    }
    @Override
    public void responseData(List<Food> data) {
        mFoods.clear();
        mFoods.addAll(data);
        mMainView.hideDialog();
        mMainView.showData();
    }
}
