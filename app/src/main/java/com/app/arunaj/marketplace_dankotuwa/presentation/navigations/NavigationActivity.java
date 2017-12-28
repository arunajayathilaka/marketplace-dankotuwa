package com.app.arunaj.marketplace_dankotuwa.presentation.navigations;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.arunaj.marketplace_dankotuwa.R;
import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiFactory;
import com.app.arunaj.marketplace_dankotuwa.presentation.BaseActivity;
import com.app.arunaj.marketplace_dankotuwa.presentation.BasePresenter;
import com.app.arunaj.marketplace_dankotuwa.presentation.login.MPLoginActivity;
import com.app.arunaj.marketplace_dankotuwa.util.MPSharedPreferences;


public class NavigationActivity extends BaseActivity implements com.app.arunaj.marketplace_dankotuwa.presentation.navigations.NavigationView, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ImageView mProfilePicView;
    private TextView mUserNameView;
    private int mId;
    private int mFragmentId;
    private INavigationPresenter mNavigationPresenter;
    private String mProfilePic;
    private String mUserName;
    private String mSearchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.home_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_closed);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mId = MPSharedPreferences.getIntPreference("id", 0);

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = mNavigationView.getHeaderView(0);
        mProfilePicView = (ImageView) headerView.findViewById(R.id.nav_header_image);
        mUserNameView = (TextView) headerView.findViewById(R.id.nav_header_name);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                //loadFragment(MyProfileFragment.newInstance());
                mNavigationView.setCheckedItem(R.id.nav_profile);
            }
        });
        mNavigationView.setNavigationItemSelectedListener(this);

        mNavigationPresenter = new NavigationPresenterImp();
        mNavigationPresenter.onAttached(this);

        if (savedInstanceState != null) {
            mFragmentId = savedInstanceState.getInt("curFragment");
            mSearchState = savedInstanceState.getString("search");
            loadFragment(getFragFromId(mFragmentId));
            mUserName = savedInstanceState.getString("userName");
            //setUserName(mUserName);
            mProfilePic = savedInstanceState.getString("proPic");
            //setProPic(mProfilePic);
        } else {
            new PrepareResources().execute();
            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {
       /* loadFragment(HomeFragment.newInstance());
        mNavigationView.setCheckedItem(R.id.nav_home);*/
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mFragmentId = item.getItemId();
        Fragment fragment = getFragFromId(mFragmentId);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (mFragmentId != R.id.nav_home) {
                mFragmentId = R.id.nav_home;
                loadHomeFragment();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public void setProPic(String pic) {

    }

    @Override
    public void setProfilePic(String mProfilepic) {

    }

    @Override
    public void setUsername(String mUsername) {

    }

    public void logout() {
        MPSharedPreferences.setBooleanPreference("loggedIn", false);
        MPSharedPreferences.setStringPreference("token", null);
        MPSharedPreferences.setIntPreference("id", -1);
        ApiFactory.setApiClient(null);
        Intent intent = new Intent(this, MPLoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void displayServerErrorToast() {
        super.displayServerErrorToast();
    }

    @Override
    public void displaySessionExpired() {
        super.displaySessionExpired();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("curFragment", mFragmentId);
        outState.putString("userName", mUserName);
        outState.putString("proPic", mProfilePic);
        outState.putString("search", mSearchState);
        super.onSaveInstanceState(outState);
    }

    public Fragment getFragFromId(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.nav_profile:
                //fragment = MyProfileFragment.newInstance();
                break;
            case R.id.nav_feedback:
                //fragment = FeedbackFragment.newInstance();
                break;
            case R.id.nav_signout:
                logout();
                break;
            default:
                //fragment = HomeFragment.newInstance();
        }
        return fragment;
    }


    public void saveSearchState(String searchInstance) {
        this.mSearchState = searchInstance;
    }

    public String getSearchState() {
        return mSearchState;
    }

    public void updateNav() {
        new PrepareResources().execute();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    private class PrepareResources extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mNavigationPresenter.getData(mId);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mNavigationPresenter.passData();
        }
    }
}
