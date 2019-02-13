package com.example.myapplication.model;

public class Food {
    private String mName;
    private int mIcon;
    private int mBackGroundColor;
    private int mPrimaryColor;

    public Food(String name, int icon, int backGroundColor, int primaryColor) {
        mName = name;
        mIcon = icon;
        mBackGroundColor = backGroundColor;
        mPrimaryColor = primaryColor;
    }

    public String getName() {
        return mName;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getBackGroundColor() {
        return mBackGroundColor;
    }

    public int getPrimaryColor() {
        return mPrimaryColor;
    }
}
