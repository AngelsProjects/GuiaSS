package moviles.guiass.ui.serviceDocuments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;

public class SolicitudServicio extends AppCompatActivity {
    @BindView(R.id.btnViewMore)
    Button btnViewMore;
    @BindView(R.id.imageView_ss)
    ImageView imageView_ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_servicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener((View.OnClickListener) this);
        //Loading Image from docs
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/solicitud_servicio_social.png")
                // .placeholder(R.drawable.plandoc)   // optional
                // .error(R.drawable.plandoc)      // optional
                .resize(400, 400)
                .into(imageView_ss);
    }
}

