package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.di.component.ActivityComponent;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseFragment;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;

public class ContactUsDetailsFragment extends BaseFragment implements ContactUsDetailsMvpView {

    public static final String TAG = "ContactUsDetailsFragment";

    @Inject
    ContactUsDetailsPresenter<ContactUsDetailsMvpView> mPresenter;

    public static ContactUsDetailsFragment newInstance(){
        Bundle args = new Bundle();
        ContactUsDetailsFragment contactUsDetailsFragment = new ContactUsDetailsFragment();
        contactUsDetailsFragment.setArguments(args);
        return contactUsDetailsFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us_details,container,false);
        ActivityComponent component = getActivityComponent();
        if(component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,view));
            mPresenter.onAttach(this);

        }
        Bundle bundle = this.getArguments();
        if(bundle != null){
            AppLogger.e(String.valueOf(bundle));
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
