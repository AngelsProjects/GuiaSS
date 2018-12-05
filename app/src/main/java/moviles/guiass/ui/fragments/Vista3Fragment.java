package moviles.guiass.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
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
import moviles.guiass.ui.views.docsSamples.AsignationLetterFragment;
import moviles.guiass.ui.views.docsSamples.ControlCardFragment;
import moviles.guiass.ui.views.docsSamples.EngagementLetterFragment;
import moviles.guiass.ui.views.docsSamples.ServiceRequestFragment;

public class Vista3Fragment extends Fragment implements View.OnClickListener {
    @BindViews({R.id.btn_cc, R.id.btn_ca, R.id.btn_ss, R.id.btn_tc})
    List<Button> btnsInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vista3, container, false);
        ButterKnife.bind(this, view);
        for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {

            case R.id.btn_ss:
                fragment = new ServiceRequestFragment();
                break;
            case R.id.btn_tc:
                fragment = new ControlCardFragment();
                break;
            case R.id.btn_ca:
                fragment = new AsignationLetterFragment();
                break;
            case R.id.btn_cc:
                fragment = new EngagementLetterFragment();
                break;
            default:
                fragment = new AsignationLetterFragment();
                break;
        }
        ((MainActivity) getActivity()).changeFragment(fragment, true);
    }
}
