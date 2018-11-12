package hcww.com.orchtech.hcww.mvpebrd.data.prefs;

import hcww.com.orchtech.hcww.mvpebrd.data.DataManager;

public interface PreferencesHelper {
    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getLang();

    void saveLang(String language);
}