package hcww.com.orchtech.hcww.mvpebrd.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import hcww.com.orchtech.hcww.mvpebrd.di.ActivityContext;
import hcww.com.orchtech.hcww.mvpebrd.di.PerActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails.ContactUsDetailsMvpPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails.ContactUsDetailsMvpView;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails.ContactUsDetailsPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist.ContactUsListAdapter;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist.ContactUsListMvpPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist.ContactUsListMvpView;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist.ContactUsListPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.home.HomeMvpPresenter;
import hcww.com.orchtech.hcww.mvpebrd.ui.home.HomeMvpView;
import hcww.com.orchtech.hcww.mvpebrd.ui.home.HomePresenter;
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
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
    @Provides
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView> presenter){
        return presenter;
    }
    @Provides
    ContactUsListMvpPresenter<ContactUsListMvpView> provideContactUsListPresenter(ContactUsListPresenter<ContactUsListMvpView> presenter)
    {
        return presenter;
    }
    @Provides
    ContactUsDetailsMvpPresenter<ContactUsDetailsMvpView> provideContactUsDetailsPresenter(ContactUsDetailsPresenter<ContactUsDetailsMvpView> presenter)
    {
        return presenter;
    }
    @Provides
    ContactUsListAdapter provideContactUsListAdapter(){
        return new ContactUsListAdapter(new ArrayList<ContactUsList>());
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}

