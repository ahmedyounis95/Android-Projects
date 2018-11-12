package hcww.com.orchtech.hcww.mvpebrd.ui.home;

import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpView;

public interface HomeMvpView extends MvpView {


    void getHomeData(HomeData homeData);


}
