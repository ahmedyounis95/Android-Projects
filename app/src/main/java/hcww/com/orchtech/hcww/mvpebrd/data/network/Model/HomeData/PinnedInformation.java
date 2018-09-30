package hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tohami.tohami on 5/9/2018.
 */

public class PinnedInformation {

    @SerializedName("Id")
    @Expose
    private Long id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("PictureUrl")
    @Expose
    private String pictureUrl;
    @SerializedName("PublishDate")
    @Expose
    private String publishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

}