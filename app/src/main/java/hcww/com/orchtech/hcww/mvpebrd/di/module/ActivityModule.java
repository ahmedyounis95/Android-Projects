package hcww.com.orchtech.hcww.mvpebrd.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import hcww.com.orchtech.hcww.mvpebrd.di.ActivityContext;
import hcww.com.orchtech.hcww.mvpebrd.di.PerActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainMvpPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainMvpView;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.splash.SplashMvpPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.splash.SplashMvpView;
import hcww.com.orchtech.hcww.mvpebrd.ui.splash.SplashPresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.AppSchedulerProvider;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}

