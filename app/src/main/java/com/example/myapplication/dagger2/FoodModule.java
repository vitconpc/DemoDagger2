package com.example.myapplication.dagger2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.myapplication.common.adapter.FoodAdapter;
import com.example.myapplication.common.adapter.FoodAdapterCallback;
import com.example.myapplication.interactor.FoodInteractor;
import com.example.myapplication.interactor.FoodInteractorCallBack;
import com.example.myapplication.interactor.FoodInteractorImpl;
import com.example.myapplication.presenter.FoodPresenter;
import com.example.myapplication.presenter.FoodPresenterImpl;
import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FoodModule {

    private Context mContext;

    public FoodModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext(){
        return mContext;
    }
        //todo các callback nên để trong attach, nếu interface đó được dùng để thể hiện thực thi thì mới tạo provide như dưới, 1 class chỉ được thay thế cho 1 interface, nếu
        //todo nếu thể hiện 1 thực thể cho 2 interface thì nó sẽ báo lỗi
//    @Provides
//    FoodInteractorCallBack provideFoodInteractorCallBack(FoodPresenterImpl foodPresenter){
//        return foodPresenter;
//    }
    //todo nếu bên cần sử dụng là class thì không cần viết hàm provide nữa mà chỉ cần inject ở Constructor là đủ, còn nếu đó là interface thì ta phải viết hàm provide ở trong lớp modul
    @Provides
    FoodPresenter provideFoodPresenter(FoodPresenterImpl foodPresenter){
        return foodPresenter;
    }

    @Provides
    FoodInteractor provideFoodInteractor(FoodInteractorImpl foodInteractor){
        return foodInteractor;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(){
        return new LinearLayoutManager(mContext);
    }
}
