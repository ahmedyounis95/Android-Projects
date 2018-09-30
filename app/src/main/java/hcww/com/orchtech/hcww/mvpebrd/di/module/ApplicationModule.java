package hcww.com.orchtech.hcww.mvpebrd.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hcww.com.orchtech.hcww.mvpebrd.data.AppDataManager;
import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.data.network.ApiHelper;
import hcww.com.orchtech.hcww.mvpebrd.data.network.AppApiHelper;
import hcww.com.orchtech.hcww.mvpebrd.data.prefs.AppPreferencesHelper;
import hcww.com.orchtech.hcww.mvpebrd.data.prefs.PreferencesHelper;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import hcww.com.orchtech.hcww.mvpebrd.di.PreferenceInfo;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppConstants;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }
    @Provides
    @ApplicationContext
    Context provideContext(){return mApplication;}

    @Provides
    Application provideApplication(){return mApplication;}

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager){return appDataManager;}

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName(){return AppConstants.PREF_NAME;
    }
    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(AppPreferencesHelper appPreferencesHelper){return appPreferencesHelper;}
}
