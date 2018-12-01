package moviles.guiass.ui.serviceDocuments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;

public class TarjetaControl extends AppCompatActivity {
    @BindView(R.id.btnViewMore)
    Button btnViewMore;
    @BindView(R.id.imageView_tc)
    ImageView imageView_tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener((View.OnClickListener) this);
        //Loading Image from docs
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/tarjeta_de_control.png")
                // .placeholder(R.drawable.plandoc)   // optional
                // .error(R.drawable.plandoc)      // optional
                .resize(400, 400)
                .into(imageView_tc);
    }
    }

