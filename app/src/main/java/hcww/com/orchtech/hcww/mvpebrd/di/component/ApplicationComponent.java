package hcww.com.orchtech.hcww.mvpebrd.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import hcww.com.orchtech.hcww.mvpebrd.MvpApp;
import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import hcww.com.orchtech.hcww.mvpebrd.di.module.ApplicationModule;
import hcww.com.orchtech.hcww.mvpebrd.di.module.NetModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    void inject(MvpApp mvpApp);

    @ApplicationContext
    Context context();

    Retrofit getRetrofit();

    Application application();

    DataManager getDataManager();
}
