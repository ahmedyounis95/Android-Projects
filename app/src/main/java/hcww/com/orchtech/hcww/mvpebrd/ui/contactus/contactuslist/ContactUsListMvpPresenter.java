package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpPresenter;

public interface ContactUsListMvpPresenter<V extends ContactUsListMvpView>
        extends MvpPresenter<V> {
    void onViewPrepared();

    void onNoInternetAccess();

}
