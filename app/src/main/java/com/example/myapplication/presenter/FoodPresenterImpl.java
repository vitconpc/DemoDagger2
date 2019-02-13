package com.example.myapplication.presenter;

import android.content.Context;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.model.Food;
import com.example.myapplication.view.MainView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FoodPresenterImpl implements FoodPresenter {

    private static final long TIME_DELAY = 2000;
    private Context mContext;
    private List<Food> mFoods;
    private MainView mMainView;

    public List<Food> getFoods() {
        return mFoods;
    }

    public FoodPresenterImpl(Context context, MainView mainView) {
        mContext = context;
        mFoods = new ArrayList<>();
        mMainView = mainView;
    }

    @Override
    public void onResume() {
        mMainView.showDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFoods.clear();
                mFoods.addAll(createData());
                mMainView.showData();
                mMainView.hideDialog();
            }

        },TIME_DELAY);
    }

    private List<Food> createData() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(mContext.getString(R.string.fish), R.drawable.fish,R.color.theme_blue_background,R.color.theme_blue_primary));
        foods.add(new Food(mContext.getString(R.string.meat), R.drawable.meat,R.color.theme_green_background,R.color.theme_green_primary));
        foods.add(new Food(mContext.getString(R.string.hotdog), R.drawable.hotdog,R.color.theme_purple_background,R.color.theme_purple_primary));
        foods.add(new Food(mContext.getString(R.string.ice_cream), R.drawable.ice_cream,R.color.theme_yellow_background,R.color.theme_yellow_primary));
        foods.add(new Food("milk", R.drawable.milk,R.color.theme_red_background,R.color.theme_red_primary));
        foods.add(new Food("beer", R.drawable.beer,R.color.theme_purple_background,R.color.theme_purple_primary));
        foods.add(new Food("alcohol", R.drawable.alcohol,R.color.theme_blue_background,R.color.theme_blue_primary));
        return foods;
    }

    @Override
    public void itemOnclick(int position) {
        mMainView.showMessage(mFoods.get(position).getName());
    }
}
