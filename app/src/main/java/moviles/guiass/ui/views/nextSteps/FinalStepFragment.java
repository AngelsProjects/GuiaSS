package moviles.guiass.ui.views.nextSteps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;


public class FinalStepFragment extends Fragment {
    @BindView(R.id.img_final)
    ImageView img_final;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_final_step, container, false);
        ButterKnife.bind(this, view);
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/reportefindoc.png")
                .placeholder(R.drawable.progress_animation)
                .into(img_final);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
