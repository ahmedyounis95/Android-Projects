package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView  {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    private ActionBarDrawerToggle mDrawerToggle;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);



        setUp();
    }


    @Override
    protected void setUp() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        mPresenter.onNavMenuCreated();

        mPresenter.onViewInitialized();
    }

    void setupNavMenu() {

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.home:
                                mPresenter.onDrawerOptionAboutClick();
                                return true;
                            case R.id.my_profile:
                                mPresenter.onDrawerRateUsClick();
                                return true;
                            case R.id.previous_complains:
                                mPresenter.onDrawerMyFeedClick();
                                return true;
                            case R.id.news:
                                mPresenter.onDrawerOptionLogoutClick();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
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
