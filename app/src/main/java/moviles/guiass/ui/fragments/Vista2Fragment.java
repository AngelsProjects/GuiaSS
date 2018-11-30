package moviles.guiass.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import moviles.guiass.ui.R;

public class Vista2Fragment extends Fragment {

    @BindView(R.id.imageView_ps)
    ImageView imageView_ps;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       /* View view = inflater.inflate(R.layout.fragment_vista2, container, false);
        ImageView imageView_ps = (ImageView) view.findViewById(R.id.imageView_ps);
        Picasso.get().load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .fit().into(imageView_ps); return view;*/


       // Picasso.with(getActivity().getApplicationContext()).load("https://randomuser.me/api/portraits/men/83.jpg").into(imageView_ps);
        return inflater.inflate(R.layout.fragment_vista2, container, false);




    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Loading Image from docs
       // Picasso.get().load("https://randomuser.me/api/portraits/men/83.jpg")
                // .placeholder(R.drawable.plandoc)   // optional
                // .error(R.drawable.plandoc)      // optional
               // .resize(400, 400)
                //.into(imageView_ps);


    }

}
