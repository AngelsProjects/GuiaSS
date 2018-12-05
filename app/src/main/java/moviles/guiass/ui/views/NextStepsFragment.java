package moviles.guiass.ui.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.R;
import moviles.guiass.ui.views.nextSteps.WorkPlanFragment;

public class NextStepsFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.btnToWork)
    Button btnViewMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_steps, container, false);
        ButterKnife.bind(this, view);
        btnViewMore.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).changeFragment(new WorkPlanFragment(), true);
    }
}
