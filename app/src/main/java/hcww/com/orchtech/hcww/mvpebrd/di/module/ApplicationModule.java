package hcww.com.orchtech.hcww.mvpebrd.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;

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

}
