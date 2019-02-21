package com.example.myapplication.common.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Food;

import java.util.List;

import javax.inject.Inject;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> mFoods;
    private FoodAdapterCallback mCallback;
    private Context mContext;

    public void setFoods(List<Food> foods) {
        mFoods = foods;
    }

    @Inject
    public FoodAdapter(Context context) {
        mContext = context;
    }

    public void onAttachCallback(FoodAdapterCallback callback){
        mCallback = callback;
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_item_food, viewGroup, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.bindData(mFoods.get(i));
    }

    @Override
    public int getItemCount() {
        return mFoods == null ? 0 : mFoods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvIcon;
        private TextView mTvFoodName;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvIcon = itemView.findViewById(R.id.iv_icon);
            mTvFoodName = itemView.findViewById(R.id.tv_food_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.itemClick(getAdapterPosition());
                }
            });
        }

        public void bindData(Food food) {
            mIvIcon.setImageResource(food.getIcon());
            mTvFoodName.setText(food.getName());
            mTvFoodName.setBackgroundColor(ContextCompat.getColor(mContext, food.getPrimaryColor()));
            mIvIcon.setBackgroundColor(ContextCompat.getColor(mContext, food.getBackGroundColor()));
        }
    }
}
