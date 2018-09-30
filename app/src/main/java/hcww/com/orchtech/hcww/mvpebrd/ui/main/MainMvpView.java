package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import java.util.List;

import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void getHomeData(HomeData homeData);
}
