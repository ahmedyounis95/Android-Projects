package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class ContactUsDetailsPresenter<V extends ContactUsDetailsMvpView> extends BasePresenter<V>
        implements ContactUsDetailsMvpPresenter<V> {

    @Inject
    public ContactUsDetailsPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }
}
