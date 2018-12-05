package moviles.guiass.ui.views.nextSteps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.R;

public class WorkPlanFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.btnViewMore)
    Button btnViewMore;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_plan, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load("http://lechtchenko.azurewebsites.net/img/plandoc2.png")
                .placeholder(R.drawable.progress_animation).into(ivPhoto);
        btnViewMore.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).changeFragment(new ReportFragment(), true);
    }
}
