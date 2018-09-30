package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import android.util.Log;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);

    }


    @Override
    public void onViewInitialized() {
        getMvpView().showLoading();
          getCompositeDisposable().add(getDataManager().getHomeData(1).
                  subscribeOn(getSchedulerProvider().io())
                  .observeOn(getSchedulerProvider().ui())
                  .subscribeWith(new DisposableSingleObserver<HomeData>() {
              @Override
              public void onSuccess(HomeData homeData) {
                  if(homeData != null)
                  {
                      getMvpView().getHomeData(homeData);
                      Log.e("home", homeData.getHomeImage().getImageUrl());
                  }
                  getMvpView().hideLoading();

              }

              @Override
              public void onError(Throwable e) {
                  if (!isViewAttached()) {
                      return;
                  }
                  Log.e("Error", "onError: " + e.getMessage());
                  handleApiError(e);
                  getMvpView().hideLoading();
              }
          }));

    }


}
