package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();
    }
