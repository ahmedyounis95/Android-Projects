package hcww.com.orchtech.hcww.mvpebrd.ui.splash;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(SchedulerProvider schedulerProvider,CompositeDisposable compositeDisposable) {

        super(schedulerProvider,compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        decideNextActivity();

    }

    private void decideNextActivity(){
        getMvpView().openMainActivity();
    }
}
