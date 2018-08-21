package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import java.util.List;

import hcww.com.orchtech.hcww.mvpebrd.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showAboutFragment();
/*
    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);*/

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void showRateUsDialog();

    void openMyFeedActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
