package hcww.com.orchtech.hcww.mvpebrd.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hcww.com.orchtech.hcww.mvpebrd.R;
import hcww.com.orchtech.hcww.mvpebrd.ui.base.BaseActivity;
import hcww.com.orchtech.hcww.mvpebrd.ui.contactus.contactuslist.ContactUsListFragment;
import hcww.com.orchtech.hcww.mvpebrd.ui.home.HomeFragment;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;

public class MainActivity extends BaseActivity implements MainMvpView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;
    private ActionBarDrawerToggle mDrawerToggle;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        Locale locale = new Locale(mPresenter.getLang());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        setUnbinder(ButterKnife.bind(this));
        AppLogger.e(mPresenter.getLang());

        mPresenter.onStartApp();
        setUp();

    }


    @Override
    public void showHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .add(R.id.cl_root_view, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit();


    }

    @Override
    public void showContactUsList() {
        Fragment f = getSupportFragmentManager().findFragmentByTag(ContactUsListFragment.TAG);
        if (!(f instanceof ContactUsListFragment)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.cl_root_view, ContactUsListFragment.newInstance(), ContactUsListFragment.TAG)
                    .addToBackStack(ContactUsListFragment.TAG)
                    .commit();

        }

    }

    public void changeLang(String lang) {
        if (lang.equals("en")) {
            mPresenter.changeLangEN();
        } else {
            mPresenter.changeLangAR();
        }

        try {
            Intent intent = new Intent();
            intent.setAction("LANG");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
        startActivity(getIntent());

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();

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
    }

    void setupNavMenu() {
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.my_profile:
                                return true;
                            case R.id.previous_complains:
                                return true;
                            case R.id.news:
                                return true;
                            case R.id.contact_us:
                                mPresenter.onDrawerOptionContactUsClick();
                                return true;
                            case R.id.language:
                                if(mPresenter.getLang().equals("en"))
                                {
                                    changeLang("ar");
                                }else{
                                    changeLang("en");
                                }
                            default:
                                return false;
                        }
                    }
                });
    }

}
