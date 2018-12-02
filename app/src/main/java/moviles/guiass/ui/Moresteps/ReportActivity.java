package moviles.guiass.ui.Moresteps;

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

import static moviles.guiass.ui.R.id.imageView_peri;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnFinal)
    Button btnViewMore;
    @BindView(R.id.imageView_winrar)
    ImageView imageView_winrar;
    @BindView(R.id.imageView_peri)
    ImageView imageView_peri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener(this);
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/repdoc.png")
                // .placeholder(R.drawable.plandoc)   // optional
                // .error(R.drawable.plandoc)      // optional
                .resize(400, 400)
                .into(imageView_winrar);
        Picasso.get()
                .load("http://lechtchenko.azurewebsites.net/img/termdoc.png")
                // .placeholder(R.drawable.plandoc)   // optional
                // .error(R.drawable.plandoc)      // optional
                .resize(400, 400)
                .into(imageView_peri);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ReportActivity.this, FinalStepActivity.class);
        startActivity(intent);
    }

}
