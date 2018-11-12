package hcww.com.orchtech.hcww.mvpebrd.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.di.component.ActivityComponent;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment implements HomeMvpView{
    public static final String TAG = "HomeFragment";
    @BindView(R.id.banner_image)
    ImageView bannerImg;
    @BindView(R.id.txt_date)
    TextView dateTxt;
    @BindView(R.id.image_info)
    ImageView infoImg;
    @BindView(R.id.txt_time)
    TextView timeTxt;
    @BindView(R.id.txt_info_title)
    TextView infoTitleTxt;


    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;

    public static HomeFragment newInstance(){
        Bundle args = new Bundle();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        mPresenter.onViewInitialized();
        return view;
    }

    @Override
    protected void setUp(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


    @Override
    public void getHomeData(HomeData homeData) {
        Glide.with(getBaseActivity()).load(homeData.getHomeImage().getImageUrl()).into(bannerImg);
        infoTitleTxt.setText(homeData.getPinnedInformation().getTitle());
        Glide.with(getBaseActivity()).load(homeData.getPinnedInformation().getPictureUrl()).into(infoImg);
    }

}
