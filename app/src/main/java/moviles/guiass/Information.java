package moviles.guiass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.Enum.MenuOptionsEnum;


public class Information extends AppCompatActivity {

    @BindViews({R.id.txt_infoTitle, R.id.txt_infoDesc})
    List<TextView> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        int option = bundle.getInt("InfoOption");
        MenuOptionsEnum selected = MenuOptionsEnum.valueOf(option);
        String title = "Informacion";
        String description = "N/A";
        System.out.println(option);
        switch (selected) {
            case RequisitosPrevios:
                description = "Requisitos Previos";
                break;
            case DatosDelServicioSocial:
                description = "Datos del Servicio Social";
                break;
            case PrimerosPasos:
                description = "Primeros Pasos";
                break;
            case DondeHacerlo:
                description = "Donde Hacerlo";
                break;
            case PasosSiguientes:
                description = "Pasos Siguientes";
                break;
            default:
                description = "Unknown";

        }
        titles.get(0).setText(title);
        titles.get(1).setText(description);
    }
}
