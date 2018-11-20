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


public class InformationActivity extends AppCompatActivity {


    // se hacen binding por medio de butterknife a los objetos de la vista XML en este caso a los TEXTVIEW'S
    // para ello se les asignan mediante los ID's txt_infoTitle, txt_infoDesc que ya se debieron haber asignado en el XML
    // @BindViews({R.id.txt_infoTitle, R.id.txt_infoDesc})
    // List<TextView> titles;


    // El metodo onCreate se inicializa para crear todos los objetos o darles algun valor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // se manda a llamar la funcioin super que en definicion es como un constructor que guarda la instancia del estado actual
        super.onCreate(savedInstanceState);
        TextView texto1, texto2;
        // aqui se asigna la vista al Activity en este caso estamos en el activity InformationActivity
        // y se  le esta asignando la vista del siguiente repositorio
        // R.layout.activity_information
        // que en definicion por carpetas: res -> layout -> activity_information.xml
        setContentView(R.layout.activity_information);

        //aqui damos por hecho que haremos binding a los objetos ya declarados anteriormente para este Activity
        ButterKnife.bind(this);

        // con el getIntent().getExtras() accedemos a todos los datos que recive este activity de otro en este caso
        // el activity main envia un parametro llamado InfoOption al activity InformationActivity y lo guardamos en una variable
        // int option
        Bundle bundle = getIntent().getExtras();
        int option = bundle.getInt("InfoOption");

        //con el valor obtenido ya de la actividad anterior realizamos un cast por medio de la clase
        // MenuOptionsEnum accediendo a su metodo valueOf y enviandole como parametro option
        MenuOptionsEnum selected = MenuOptionsEnum.valueOf(option);


        // se asignan los datos por default de la vista de InformationActivity
        String title = "Informacion";
        String description = "N/A";


        //Se realiza una comparacion en base al resultado que nos arroje la variable select
        // Este resultado se realiza mediante MenuOptionsEnum que es una clase de tipo ENUM(enumerable)
        // esta clase enumerable solo enumera N numero de datos para poder acceder a ellos de manera mas facil
        // en ves de comparar los datos como:
        // si es igual a 1, 2, 3, o 4
        // mas facil compararlos de la siguiente manera:
        // si es RequisitosPrevios, DatosDelServicioSocial, PrimerosPasos.... etc.
        // Si deceas saber mas como funciona el enumerable revisar la clase localizada en:
        // moviles -> guiass -> Enum -> MenuOptionsEnum.java
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

        // titles.get(0).setText(title);
        // titles.get(1).setText(description);
    }
}
