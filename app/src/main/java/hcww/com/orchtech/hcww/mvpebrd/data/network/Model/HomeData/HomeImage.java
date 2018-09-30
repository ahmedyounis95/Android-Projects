package hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData;

/**
 * Created by tohami.tohami on 5/9/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeImage {

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl= videoUrl;
    }

    @SerializedName("showVideo")
    @Expose
    private boolean showVideo;

    public boolean getShowVideo() {
        return showVideo;
    }

    public void setShowVideo(boolean showVideo) {
        this.showVideo= showVideo;
    }
}