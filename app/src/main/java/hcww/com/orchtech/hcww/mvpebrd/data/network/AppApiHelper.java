package hcww.com.orchtech.hcww.mvpebrd.data.network;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.com.orchtech.hcww.mvpebrd.MvpApp;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import retrofit2.Retrofit;

@Singleton
public class AppApiHelper implements ApiHelper {

    private Context mContext;

    @Inject
    public AppApiHelper(@ApplicationContext Context context){
        this.mContext = context;
    }

    @Override
    public Single<HomeData> getHomeData(int languageId) {
        Retrofit retrofit = ((MvpApp) mContext).getComponent().getRetrofit();
        return retrofit.create(ApiHelper.class).getHomeData(languageId);
    }
}
