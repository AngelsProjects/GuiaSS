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

public class ReportFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btnFinal)
    Button btnViewMore;
    @BindView(R.id.imageView_winrar)
    ImageView imageView_winrar;
    @BindView(R.id.imageView_peri)
    ImageView imageView_peri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        ButterKnife.bind(this, view);
        btnViewMore.setOnClickListener(this);
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/repdoc.png")
                .placeholder(R.drawable.progress_animation)
                .into(imageView_winrar);
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/termdoc.png")
                .placeholder(R.drawable.progress_animation)
                .into(imageView_peri);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).changeFragment(new FinalStepFragment(), true);
    }
}
