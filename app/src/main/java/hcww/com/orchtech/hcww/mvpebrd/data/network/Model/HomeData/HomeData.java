package hcww.com.orchtech.hcww.mvpebrd.data.network.Model.HomeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by tohami.tohami on 5/9/2018.
 */

public class HomeData {
    @SerializedName("pinnedInformation")
    @Expose
    private PinnedInformation pinnedInformation;
    @SerializedName("homeImage")
    @Expose
    private HomeImage homeImage;

    @SerializedName("survey")
    @Expose
    private Survey survey;

    public PinnedInformation getPinnedInformation() {
        return pinnedInformation;
    }

    public void setPinnedInformation(PinnedInformation pinnedInformation) {
        this.pinnedInformation = pinnedInformation;
    }

    public HomeImage getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(HomeImage homeImage) {
        this.homeImage = homeImage;
    }
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public class Survey {

        @SerializedName("ActiveSurvey")
        @Expose
        private Boolean activeSurvey;
        @SerializedName("Id")
        @Expose
        private Integer id;
        @SerializedName("Name")
        @Expose
        private String name;

        public Boolean getActiveSurvey() {
            return activeSurvey;
        }

        public void setActiveSurvey(Boolean activeSurvey) {
            this.activeSurvey = activeSurvey;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}