package moviles.guiass.ui.Moresteps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;

public class WorkPlanActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnViewMore)
    Button btnViewMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandetrabajo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WorkPlanActivity.this, ReportActivity.class);
        startActivity(intent);
    }

}
