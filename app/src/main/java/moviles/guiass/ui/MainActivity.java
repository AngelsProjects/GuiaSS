package moviles.guiass.ui;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

import static moviles.guiass.Enum.MenuOptionsEnum.*;


public class MainActivity extends AppCompatActivity implements /*View.OnClickListener, */NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.nav_view)
    NavigationView navigationView;

   /* @BindViews({R.id.btn_req, R.id.btn_dh, R.id.btn_dss, R.id.btn_pp, R.id.btn_ps})
    List<Button> btnsInfo;*/

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
     /*   for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }/*
    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle bundle = new Bundle();
        switch (v.getId()) {

            case R.id.btn_req:
                intent = new Intent(MainActivity.this, InformationActivity.class);
                bundle.putInt("InfoOption", RequisitosPrevios.getValue());
                break;
            case R.id.btn_dh:
                intent = new Intent(MainActivity.this, WhereToDoActivity.class);
                bundle.putInt("InfoOption", DondeHacerlo.getValue());
                break;
            case R.id.btn_dss:
                intent = new Intent(MainActivity.this, GeneralDataActivity.class);
                bundle.putInt("InfoOption", DatosDelServicioSocial.getValue());
                break;
            case R.id.btn_pp:
                intent = new Intent(MainActivity.this, StepByStepActivity.class);
                break;
            case R.id.btn_ps:
                intent = new Intent(MainActivity.this, NextStepsActivity.class);
                bundle.putInt("InfoOption", PasosSiguientes.getValue());
                break;
            default:
                intent = new Intent(MainActivity.this, InformationActivity.class);
                break;
        }
        intent.putExtras(bundle);

        startActivity(intent);
    }

*/


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_remove) {

        } else if (id == R.id.nav_add) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_search) {

        } else if (id == R.id.nav_login) {

        } else if (id == R.id.nav_signoff) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
