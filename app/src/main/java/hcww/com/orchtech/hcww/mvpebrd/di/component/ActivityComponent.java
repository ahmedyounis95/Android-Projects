package hcww.com.orchtech.hcww.mvpebrd.di.component;

import dagger.Component;
import hcww.com.orchtech.hcww.mvpebrd.di.PerActivity;
import hcww.com.orchtech.hcww.mvpebrd.di.module.ActivityModule;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainFragment;
import hcww.com.orchtech.hcww.mvpebrd.ui.splash.SplashActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent  {


    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(MainFragment mainFragment);

}
