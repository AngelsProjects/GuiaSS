package moviles.guiass.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.fasterxml.jackson.databind.Module;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import moviles.guiass.ui.fragments.HomeFragment;
import moviles.guiass.ui.fragments.Vista2Fragment;
import moviles.guiass.ui.fragments.Vista3Fragment;

public class StepByStepActivity extends AppCompatActivity {
    @BindView(R.id.imageView_ps)
    ImageView imageView_ps;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_1:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_2:
                    selectedFragment = new Vista2Fragment();
                    break;
                case R.id.nav_3:
                    selectedFragment = new Vista3Fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_pasoa_paso);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.btmNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

}
