package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Locale;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);

    }


    @Override
    public void onStartApp() {
        getMvpView().showHomeFragment();
    }

    @Override
    public void onDrawerOptionContactUsClick() {
        getMvpView().showContactUsList();
    }

    @Override
    public void changeLangEN() {
        getDataManager().saveLang("en");

    }

    @Override
    public void changeLangAR() {
        getDataManager().saveLang("ar");
    }

    @Override
    public String getLang() {
        return getDataManager().getLang();
    }


}
