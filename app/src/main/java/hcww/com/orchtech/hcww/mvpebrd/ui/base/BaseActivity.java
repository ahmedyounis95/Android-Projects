package hcww.com.orchtech.hcww.mvpebrd.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.Unbinder;
import hcww.com.orchtech.hcww.mvpebrd.MvpApp;
import hcww.com.orchtech.hcww.mvpebrd.di.component.ActivityComponent;
import hcww.com.orchtech.hcww.mvpebrd.di.component.DaggerActivityComponent;
import hcww.com.orchtech.hcww.mvpebrd.di.module.ActivityModule;
import hcww.com.orchtech.hcww.mvpebrd.ui.main.MainActivity;
import hcww.com.orchtech.hcww.mvpebrd.utils.CommonUtils;
import hcww.com.orchtech.hcww.mvpebrd.utils.NetworkUtils;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {
    private ProgressDialog mProgressDialog;
    private ActivityComponent mActivityComponent;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "some error occurred", Toast.LENGTH_SHORT).show();
        }
    }

    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void openActivityOnTokenExpire() {
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    public void onFragmentAttached() {

    }


    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setUnbinder(Unbinder unbinder) {
        mUnbinder = unbinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();

    }


    protected abstract void setUp();
}
