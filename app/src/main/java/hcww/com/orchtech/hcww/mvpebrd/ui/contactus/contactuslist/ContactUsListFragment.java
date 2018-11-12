package hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import hcww.com.orchtech.hcww.mvpebrd.di.component.ActivityComponent;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseFragment;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactusdetails.ContactUsDetailsFragment;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;

public class ContactUsListFragment extends BaseFragment implements ContactUsListMvpView,ContactUsListAdapter.Callback{

    public static final String TAG = "ContactUsListFragment";

    @Inject
    ContactUsListPresenter<ContactUsListMvpView> mPresenter;
    @Inject
    ContactUsListAdapter mContactUsListAdapter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.contact_us_list_recycler)
    RecyclerView mRecyclerView;

    public static ContactUsListFragment newInstance(){
        Bundle args = new Bundle();
        ContactUsListFragment contactUsListFragment = new ContactUsListFragment();
        contactUsListFragment.setArguments(args);
        return contactUsListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us_list,container,false);
        ActivityComponent component = getActivityComponent();
        if(component != null)
        {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,view));
            mPresenter.onAttach(this);
            mContactUsListAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mContactUsListAdapter);
        mContactUsListAdapter.setClickListener(this);

        mPresenter.onViewPrepared();

    }

    @Override
    public void onContactUsListEmptyViewRetryClick() {
        View view = null;
        setUp(view);
    }

    @Override
    public void onContactUsListClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", (int) mContactUsListAdapter.getItemId(position));
        ContactUsDetailsFragment contactUsDetailsFragment = ContactUsDetailsFragment.newInstance();
        contactUsDetailsFragment.setArguments(bundle);
        AppLogger.e("onclick",position);
        if(mContactUsListAdapter.getItemId(position) != 0){
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.cl_root_view, contactUsDetailsFragment, ContactUsDetailsFragment.TAG)
                    .addToBackStack(ContactUsListFragment.TAG)
                    .commit();

        }

    }

    @Override
    public boolean isNetworkConnected() {
        return super.isNetworkConnected();
    }

    @Override
    public void updateContactUsList(List<ContactUsList> contactUsList) {
        mContactUsListAdapter.addItems(contactUsList);
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


}
