package com.example.myapplication.interactor;

import android.content.Context;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FoodInteractorImpl implements FoodInteractor {

    private Context mContext;
    private FoodInteractorCallBack mCallBack;
    private static final long TIME_DELAY = 2000;

    @Inject
    public FoodInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public void onAttachCallback(FoodInteractorCallBack callBack) {
        mCallBack = callBack;
    }

    public void getData() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCallBack.responseData(createData());
            }

        }, TIME_DELAY);
    }

    private List<Food> createData() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(mContext.getString(R.string.fish), R.drawable.fish, R.color.theme_blue_background, R.color.theme_blue_primary));
        foods.add(new Food(mContext.getString(R.string.meat), R.drawable.meat, R.color.theme_green_background, R.color.theme_green_primary));
        foods.add(new Food(mContext.getString(R.string.hotdog), R.drawable.hotdog, R.color.theme_purple_background, R.color.theme_purple_primary));
        foods.add(new Food(mContext.getString(R.string.ice_cream), R.drawable.ice_cream, R.color.theme_yellow_background, R.color.theme_yellow_primary));
        foods.add(new Food("milk", R.drawable.milk, R.color.theme_red_background, R.color.theme_red_primary));
        foods.add(new Food("beer", R.drawable.beer, R.color.theme_purple_background, R.color.theme_purple_primary));
        foods.add(new Food("alcohol", R.drawable.alcohol, R.color.theme_blue_background, R.color.theme_blue_primary));
        return foods;
    }
}
