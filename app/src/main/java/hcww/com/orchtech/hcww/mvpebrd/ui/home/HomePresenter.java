package hcww.com.orchtech.hcww.mvpebrd.ui.home;

import android.util.Log;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;


public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {
    private int lang;

    @Inject
    public HomePresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);

    }

    @Override
    public void onViewInitialized() {
        getMvpView().showLoading();
        if(getDataManager().getLang().equals("en"))
        {
            lang = 1;
        }else
        {
            lang = 2;
        }
          getCompositeDisposable().add(getDataManager().getHomeData(lang).
                  subscribeOn(getSchedulerProvider().io())
                  .observeOn(getSchedulerProvider().ui())
                  .subscribeWith(new DisposableSingleObserver<HomeData>() {
              @Override
              public void onSuccess(HomeData homeData) {
                  if(homeData != null)
                  {
                      getMvpView().getHomeData(homeData);
                      AppLogger.e(homeData.getHomeImage().getImageUrl());
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
