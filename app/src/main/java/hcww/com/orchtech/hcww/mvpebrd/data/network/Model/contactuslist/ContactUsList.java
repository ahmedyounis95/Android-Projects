
package hcww.com.orchtech.hcww.mvpebrd.data.network.Model.contactuslist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import hcww.com.orchtech.hcww.mvpebrd.utils.AppConstants;

@Entity(tableName = AppConstants.CONTACT_US_TABLE_NAME)
public class ContactUsList implements Serializable
{

    @PrimaryKey
    @SerializedName("Id")
    private Integer id;
    @SerializedName("Title")
    @ColumnInfo(name = "Title")
    private String title;
    @SerializedName("ImageUrl")
    @ColumnInfo(name = "ImageUrl")
    private String imageUrl;
    private final static long serialVersionUID = -1200444945916768216L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
