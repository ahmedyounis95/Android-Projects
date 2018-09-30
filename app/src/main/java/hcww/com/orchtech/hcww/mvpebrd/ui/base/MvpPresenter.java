package hcww.com.orchtech.hcww.mvpebrd.ui.base;

import com.androidnetworking.error.ANError;

import retrofit2.HttpException;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();



    void handleApiError(Throwable e);

    void setUserAsLoggedOut();
}
