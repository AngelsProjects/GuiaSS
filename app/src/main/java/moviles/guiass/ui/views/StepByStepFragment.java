package moviles.guiass.ui.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;
import moviles.guiass.ui.fragments.HomeFragment;
import moviles.guiass.ui.fragments.Vista2Fragment;
import moviles.guiass.ui.fragments.Vista3Fragment;

public class StepByStepFragment extends Fragment {
    View _rootView;
    Fragment selectedFragment = null;
    @BindView(R.id.btmNavigation)
    BottomNavigationView navigation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (_rootView == null) {
            _rootView = inflater.inflate(R.layout.fragment_step_by_step, container, false);
        }
        if (selectedFragment == null) {
            selectedFragment = new HomeFragment();
        }
        ButterKnife.bind(this, _rootView);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getFragmentManager().beginTransaction().replace(R.id.fragment_steps, selectedFragment).commit();
        return _rootView;
    }

    @Override
    public void onDestroyView() {
        if (_rootView.getParent() != null) {
            ((ViewGroup) _rootView.getParent()).removeView(_rootView);
        }
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Put Data in the Bundle here
        super.onSaveInstanceState(savedInstanceState);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

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
            getFragmentManager().beginTransaction().replace(R.id.fragment_steps, selectedFragment).commit();
            return true;
        }
    };
}
