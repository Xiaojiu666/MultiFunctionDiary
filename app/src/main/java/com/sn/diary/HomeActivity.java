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

    }

    @Override
    public void initViewBefore() {

    }

    private static final int TAB_HOME = 0;
    private HomeFragment homeFragment;

    private void contorlFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case TAB_HOME:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.home_framelayout, homeFragment);
                }
                showFragment(fragmentTransaction, homeFragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
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
        if (id == R.id.nav_camera) {
            contorlFragment(TAB_HOME);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
