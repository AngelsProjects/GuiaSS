package moviles.guiass.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.Enum.MenuOptionsEnum;
import moviles.guiass.R;

public class Text extends AppCompatActivity  {
TextView texto1, texto2;

    @BindViews({R.id.txt_infoTitle, R.id.txt_infoDesc})
    List<TextView> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.requisitosprevios);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        int option = bundle.getInt("InfoOption");

        MenuOptionsEnum selected = MenuOptionsEnum.valueOf(option);



        String title = "Informacion";
        String description = "N/A";


        switch (selected) {
            case RequisitosPrevios:
                texto1=(TextView)findViewById(R.id.textViewInfo3);
                texto1.setText("Hola");
                description = "1-Tener 70% de tu carre terminada." +
                        "-¿No sabes si lo tienes?" +
                        "Entrar a ese link " +
                        "https://sge.mexicali.tecnm.mx/alumnos\n" +
                        "/historico/kardex-calificaciones" +
                        "Si en ¨Creditos aprobados¨ dice: 182" +
                        "Podras realizar tu servicio" +
                        "2-Saber si ya inicio la inscripsiones." +
                        "-¿No lo sabes?" +
                        "Acude a las oficinas del servicio social \n" +
                        "o \n" +
                        "habla a este telefono: 5804911 " +
                        "3-Contar con los 5 creditos \n" +
                        "complementarios." +
                        "-En grado caso de no tener los 182 \n" +
                        "puntos completos estos seran \n" +
                        "completados con los 5 creditso.";
                /*description = "Requisitos Previos";*/

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
        // como anteriormente teniamos una lista de TEXTVIEWS solo accedemos al text view con su respectiva posicion
        // posicion 0 y 1
        // y se ingresan los textos de descripcion y titulo.

    }

}
