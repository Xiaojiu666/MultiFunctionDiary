package com.sn.diary;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.sn.diary.mvp.base.BaseAppCompatActivity;
import com.sn.diary.mvp.base.BaseFragment;
import com.sn.diary.mvp.fragment.HomeFragment;
import com.sn.diary.mvp.fragment.SettingFragment;
import com.sn.sndiary.R;

import butterknife.BindView;

public class HomeActivity extends BaseAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //    @BindView(R.id.action_a)
//    FloatingActionButton actionA;
//    @BindView(R.id.action_b)
//    FloatingActionButton actionB;
//    @BindView(R.id.multiple_actions)
//    FloatingActionsMenu menuMultipleActions;
    @BindView(R.id.toolbar)
    Toolbar baseToolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initVariables() {
    }

    @Override
    public void initViews() {
//        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
//        actionC.setTitle("Hide/Show Action above");
//        actionC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
//            }
//        });
//        menuMultipleActions.addButton(actionC);
        initDrawerToggle();
        contorlFragment(TAB_HOME);
    }

    private void initDrawerToggle() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, baseToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void initOnClick() {
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initViewBefore() {

    }

    private static final int TAB_HOME = 0;
    private static final int TAB_SETTING = 4;
    private HomeFragment homeFragment;
    private SettingFragment settingFragment;

    private void contorlFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragments(fragmentTransaction, position);
        switch (position) {
            case TAB_HOME:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.home_framelayout, homeFragment);
                }
                showFragment(fragmentTransaction, homeFragment);
                break;
            case TAB_SETTING:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    fragmentTransaction.add(R.id.home_framelayout, settingFragment);
                }
                showFragment(fragmentTransaction, settingFragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    // 除了自己 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
    private void hideFragments(FragmentTransaction transaction, int position) {
        if (homeFragment != null && position != TAB_HOME) {
            transaction.hide(homeFragment);
        }
        if (settingFragment != null && position != TAB_SETTING) {
            transaction.hide(settingFragment);
        }
    }

    private void showFragment(FragmentTransaction transaction, BaseFragment fragment) {
        if (fragment.isVisible()) {
            transaction.hide(fragment);
        } else {
            transaction.show(fragment);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_drawer_home) {
            contorlFragment(TAB_HOME);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_drawer_setting) {
            contorlFragment(TAB_SETTING);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawerLayout.closeDrawers();
        return true;
    }
}
