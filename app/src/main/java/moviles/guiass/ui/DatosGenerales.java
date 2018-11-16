package moviles.guiass.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import moviles.guiass.R;

public class DatosGenerales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView texto1, texto2;
        setContentView(R.layout.activity_datos_generales);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "HOLA", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


                texto1=(TextView)findViewById(R.id.textViewInfo5);
        texto1.setText("Daros generales");


    }

}
