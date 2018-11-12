package hcww.com.orchtech.hcww.mvpebrd.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;
import hcww.com.orchtech.hcww.mvpebrd.di.ApplicationContext;
import hcww.com.orchtech.hcww.mvpebrd.di.PreferenceInfo;
@Singleton
public class AppPreferencesHelper implements PreferencesHelper{
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,@PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return 0;
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {

    }

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public void setCurrentUserId(Long userId) {

    }

    @Override
    public String getLang() {
        return mPrefs.getString("LANG","ar");
    }

    @Override
    public void saveLang(String language) {
        mPrefs.edit().putString("LANG",language).apply();
    }
}
