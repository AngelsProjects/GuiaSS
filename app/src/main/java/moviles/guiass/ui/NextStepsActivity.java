package moviles.guiass.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.ui.Moresteps.WorkPlanActivity;

public class NextStepsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnToWork)
    Button btnViewMore;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_steps);
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
