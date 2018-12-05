package moviles.guiass.ui.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    @BindViews({R.id.btn_req, R.id.btn_dh, R.id.btn_dss, R.id.btn_pp, R.id.btn_ps})
    List<Button> btnsInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {

            case R.id.btn_req:
                fragment = new InformationFragment();
                break;
            case R.id.btn_dh:
                fragment = new WhereToDoFragment();
                break;
            case R.id.btn_dss:
                fragment = new GeneralDataFragment();
                break;
            case R.id.btn_pp:
                fragment = new StepByStepFragment();
                break;
            case R.id.btn_ps:
                fragment = new NextStepsFragment();
                break;
            default:
                fragment = new InformationFragment();
                break;
        }
        ((MainActivity) getActivity()).changeFragment(fragment, true);

    }
}
