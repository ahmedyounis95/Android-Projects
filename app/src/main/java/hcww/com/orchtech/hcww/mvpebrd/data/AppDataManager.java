package hcww.com.orchtech.hcww.mvpebrd.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.com.orchtech.hcww.mvpebrd.data.network.ApiHelper;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.data.prefs.PreferencesHelper;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import io.reactivex.Single;
import retrofit2.http.Query;

@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper, PreferencesHelper PreferencesHelper){
        mContext = context;
        mApiHelper = apiHelper;
        mPreferencesHelper = PreferencesHelper;
    }

    @Override
    public Single<HomeData> getHomeData(@Query("languageId") int languageId){
        return mApiHelper.getHomeData(languageId);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }
}
