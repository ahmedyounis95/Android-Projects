package hcww.com.orchtech.hcww.mvpebrd.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import hcww.com.orchtech.hcww.mvpebrd.MvpApp;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import hcww.com.orchtech.hcww.mvpebrd.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp mvpApp);

    @ApplicationContext
    Context context();

    Application application();
}
