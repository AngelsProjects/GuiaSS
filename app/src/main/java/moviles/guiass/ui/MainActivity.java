package moviles.guiass.ui;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.ui.views.GeneralDataFragment;
import moviles.guiass.ui.views.InformationFragment;
import moviles.guiass.ui.views.MainFragment;
import moviles.guiass.ui.views.NextStepsFragment;
import moviles.guiass.ui.views.StepByStepFragment;
import moviles.guiass.ui.views.WhereToDoFragment;
import moviles.guiass.ui.views.lateralMenu.AddUserFragment;
import moviles.guiass.ui.views.lateralMenu.UsersFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private FragmentManager mFragmentManager;


    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getSupportFragmentManager();
        changeFragment(new MainFragment(), false);
    }

    public void changeFragment(Fragment fragment, boolean needToAddBackstack) {
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container_menu, fragment);
        mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (needToAddBackstack)
            mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.START)) {
            drawer.closeDrawer(Gravity.START);
        }
        if (drawer.isDrawerOpen(Gravity.START)) {
            drawer.closeDrawer(Gravity.START);
        } else if (mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_user:
                fragment = new UsersFragment();
                break;
         /*   case R.id.nav_remove:
                break;*/
            case R.id.nav_add:
                fragment = new AddUserFragment();
                break;
            case R.id.nav_manage:
                fragment = new MainFragment();
                break;
          /*  case R.id.nav_search:
                break;*/
            case R.id.nav_login:
            case R.id.nav_signoff:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
        }

        changeFragment(fragment, false);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
