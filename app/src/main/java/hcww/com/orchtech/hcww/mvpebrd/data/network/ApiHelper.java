package hcww.com.orchtech.hcww.mvpebrd.data.network;

import java.util.List;

import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData.HomeData;
import hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist.ContactUsList;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("api/HomeData")
    Single<HomeData> getHomeData(@Query("languageId") int languageId);

    @GET("api/Companies")
    Single<List<ContactUsList>> getContactUsList(@Query("languageId") int languageId);


}
