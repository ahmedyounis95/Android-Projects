package hcww.com.orchtech.hcww.mvpebrd.ui.base;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private static final String TAG = "BasePresenter";

    private V mMvpView;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    @Inject
    public BasePresenter(SchedulerProvider schedulerProvider ,CompositeDisposable compositeDisposable) {
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }
    public V getMvpView() {
        return mMvpView;
    }


    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }

}
