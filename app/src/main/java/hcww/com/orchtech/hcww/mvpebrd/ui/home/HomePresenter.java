package hcww.com.orchtech.hcww.mvpebrd.ui.home;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {
    @Inject
    public HomePresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable){
        super(schedulerProvider,compositeDisposable);
    }
}
