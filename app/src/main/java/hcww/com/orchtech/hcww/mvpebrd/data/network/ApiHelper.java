package hcww.com.orchtech.hcww.mvpebrd.data.network;

import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("api/HomeData")
    Single<HomeData> getHomeData(@Query("languageId") int languageId);

}
