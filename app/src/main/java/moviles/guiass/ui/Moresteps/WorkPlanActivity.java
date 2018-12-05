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

public class WorkPlanActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnViewMore)
    Button btnViewMore;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandetrabajo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener(this);
        //Loading Image from docs
        Picasso.get()
                .load("https://i.imgur.com/VQcCUMK.png")
                // .placeholder(R.drawable.plandoc)
                .into(ivPhoto);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WorkPlanActivity.this, ReportActivity.class);
        startActivity(intent);
    }

}
