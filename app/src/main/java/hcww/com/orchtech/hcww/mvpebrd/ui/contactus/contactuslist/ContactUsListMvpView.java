package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist;

import java.util.List;

import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpView;

public interface ContactUsListMvpView extends MvpView {
    void updateContactUsList(List<ContactUsList> contactUsList);
}
