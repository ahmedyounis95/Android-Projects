package hcww.com.orchtech.hcww.mvpebrd.data;

import hcww.com.orchtech.hcww.mvpebrd.data.network.ApiHelper;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.data.prefs.PreferencesHelper;
import io.reactivex.Single;
import retrofit2.http.Query;

public interface DataManager extends PreferencesHelper,ApiHelper {

    Single<HomeData> getHomeData(@Query("languageId") int languageId);

    enum LoggedInMode{
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGED_IN(1);

        private final int mType;

        LoggedInMode(int type){
            mType = type;
        }

        public int getType(){
            return mType;
        }
    }
}
