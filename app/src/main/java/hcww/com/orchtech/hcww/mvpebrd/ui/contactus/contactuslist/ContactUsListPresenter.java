package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BasePresenter;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;
import hcww.com.orchtech.hcww.mvpebrd.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;

public class ContactUsListPresenter<V extends ContactUsListMvpView> extends BasePresenter<V>
        implements ContactUsListMvpPresenter<V> {

    private int lang;

    @Inject
    public ContactUsListPresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        if (getDataManager().getLang().equals("en"))
            lang = 1;
        else
            lang = 2;
        getCompositeDisposable().add(getDataManager().getContactUsList(lang)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableSingleObserver<List<ContactUsList>>() {

                    @Override
                    public void onSuccess(List<ContactUsList> contactUsLists) {
                        getMvpView().showLoading();
                        if (contactUsLists != null && contactUsLists.size() > 0) {
                            getMvpView().updateContactUsList(contactUsLists);
                            getDataManager().insert(contactUsLists);
                        }
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isViewAttached()) {
                            return;
                        }
                        handleApiError(e);
                        AppLogger.e("onError");
                        onNoInternetAccess();
                        getMvpView().hideLoading();

                    }
                }));

    }

    @Override
    public void onNoInternetAccess() {

        getCompositeDisposable().add(getDataManager().getAllContactShows()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ContactUsList>>() {
                    @Override
                    public void accept(List<ContactUsList> contactUsLists) throws Exception {
                        if(contactUsLists != null && contactUsLists.size() != 0) {
                            getMvpView().updateContactUsList(contactUsLists);
                            getMvpView().hideLoading();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }
}
