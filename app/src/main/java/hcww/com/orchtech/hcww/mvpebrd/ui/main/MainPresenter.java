package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);

    }

    @Override
    public void onDrawerOptionAboutClick() {
    }

    @Override
    public void onDrawerOptionLogoutClick() {

    }

    @Override
    public void onDrawerRateUsClick() {

    }

    @Override
    public void onDrawerMyFeedClick() {

    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onCardExhausted() {

    }

    @Override
    public void onNavMenuCreated() {

    }
}
