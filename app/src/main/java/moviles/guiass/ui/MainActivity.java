package moviles.guiass.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.R;

import static moviles.guiass.Enum.MenuOptionsEnum.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindViews({R.id.btn_req, R.id.btn_dh, R.id.btn_dss, R.id.btn_pp, R.id.btn_ps})
    List<Button> btnsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Information.class);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.btn_req:
                bundle.putInt("InfoOption", RequisitosPrevios.getValue());

                break;
            case R.id.btn_dh:
                bundle.putInt("InfoOption", DondeHacerlo.getValue());
                break;
            case R.id.btn_dss:
                bundle.putInt("InfoOption", DatosDelServicioSocial.getValue());
                break;
            case R.id.btn_pp:
                bundle.putInt("InfoOption", PrimerosPasos.getValue());
                break;
            case R.id.btn_ps:
                bundle.putInt("InfoOption", PasosSiguientes.getValue());
                break;
            default:

                break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
