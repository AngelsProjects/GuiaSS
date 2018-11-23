package moviles.guiass.ui;

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
import moviles.guiass.R;
import moviles.guiass.ui.Moresteps.WorkPlanActivity;

public class NextStepsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.buttonREP)
    Button btnViewMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_steps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        btnViewMore.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(NextStepsActivity.this, WorkPlanActivity.class);
        startActivity(intent);
    }

}