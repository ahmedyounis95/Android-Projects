package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import hcww.com.orchtech.hcww.mvpebrd.di.PerActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onStartApp();

    void onDrawerOptionContactUsClick();

    void changeLangEN();

    void changeLangAR();

    String getLang();
    }
