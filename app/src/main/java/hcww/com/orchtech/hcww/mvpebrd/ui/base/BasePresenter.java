package hcww.com.orchtech.hcww.mvpebrd.ui.base;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private static final String TAG = "BasePresenter";
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final DataManager mDataManager;
    private V mMvpView;
    @Inject
    public BasePresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable,DataManager dataManager) {
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
        this.mDataManager = dataManager;
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

    public DataManager getDataManager(){return mDataManager;}


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public void handleApiError(Throwable e) {

        String message = "";
        try {
            if (e instanceof IOException) {
                message = "No internet connection!";
            } else if (e instanceof com.jakewharton.retrofit2.adapter.rxjava2.HttpException) {
                com.jakewharton.retrofit2.adapter.rxjava2.HttpException error = (com.jakewharton.retrofit2.adapter.rxjava2.HttpException) e;
                String errorBody = error.response().errorBody().string();
                JSONObject jObj = new JSONObject(errorBody);

                message = jObj.getString("error");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (TextUtils.isEmpty(message)) {
            message = "Unknown error occurred! Check LogCat.";
        }

        getMvpView().showMessage(message);

    }

    @Override
    public void setUserAsLoggedOut() {

    }



    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }

    }
}
