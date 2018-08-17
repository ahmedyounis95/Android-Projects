package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.BindView;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView  {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;



    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void showAboutFragment() {

    }

    @Override
    public void updateUserName(String currentUserName) {

    }

    @Override
    public void updateUserEmail(String currentUserEmail) {

    }

    @Override
    public void updateUserProfilePic(String currentUserProfilePicUrl) {

    }

    @Override
    public void updateAppVersion() {

    }

    @Override
    public void showRateUsDialog() {

    }

    @Override
    public void openMyFeedActivity() {

    }

    @Override
    public void closeNavigationDrawer() {

    }

    @Override
    public void lockDrawer() {

    }

    @Override
    public void unlockDrawer() {

    }
}
