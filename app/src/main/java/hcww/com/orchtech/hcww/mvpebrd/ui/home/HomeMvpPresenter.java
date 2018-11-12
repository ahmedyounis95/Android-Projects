package hcww.com.orchtech.hcww.mvpebrd.ui.home;

import hcww.com.orchtech.hcww.mvpebrd.di.PerActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpPresenter;

@PerActivity
public interface HomeMvpPresenter<V extends HomeMvpView> extends MvpPresenter<V> {
    void onViewInitialized();

}
