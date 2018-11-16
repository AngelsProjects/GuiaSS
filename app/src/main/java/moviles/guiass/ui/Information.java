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


public class Information extends AppCompatActivity {


    // se hacen binding por medio de butterknife a los objetos de la vista XML en este caso a los TEXTVIEW'S
    // para ello se les asignan mediante los ID's txt_infoTitle, txt_infoDesc que ya se debieron haber asignado en el XML
    @BindViews({R.id.txt_infoTitle, R.id.txt_infoDesc})
    List<TextView> titles;


    // El metodo onCreate se inicializa para crear todos los objetos o darles algun valor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // se manda a llamar la funcioin super que en definicion es como un constructor que guarda la instancia del estado actual
        super.onCreate(savedInstanceState);
        TextView texto1, texto2;
        // aqui se asigna la vista al Activity en este caso estamos en el activity Information
        // y se  le esta asignando la vista del siguiente repositorio
        // R.layout.activity_information
        // que en definicion por carpetas: res -> layout -> activity_information.xml
        setContentView(R.layout.activity_information);

        //aqui damos por hecho que haremos binding a los objetos ya declarados anteriormente para este Activity
        ButterKnife.bind(this);

        // con el getIntent().getExtras() accedemos a todos los datos que recive este activity de otro en este caso
        // el activity main envia un parametro llamado InfoOption al activity Information y lo guardamos en una variable
        // int option
        Bundle bundle = getIntent().getExtras();
        int option = bundle.getInt("InfoOption");

        //con el valor obtenido ya de la actividad anterior realizamos un cast por medio de la clase
        // MenuOptionsEnum accediendo a su metodo valueOf y enviandole como parametro option
        MenuOptionsEnum selected = MenuOptionsEnum.valueOf(option);


        // se asignan los datos por default de la vista de Information
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
                texto1=(TextView)findViewById(R.id.textViewInfo3);
                texto1.setText("¿Que ocupas?");
                texto2=(TextView)findViewById(R.id.textViewInfo4);
                texto2.setText("1-Tener 70% de tu carre terminada.\n" +
                        "-¿No sabes si lo tienes?\n" +
                        "Entrar a ese link\n" +
                        "https://sge.mexicali.tecnm.mx/alumnos/historico/kardex-calificaciones\n" +
                        "Si en ¨Creditos aprobados¨ dice: 182\n" +
                        "Podras realizar tu servicio\n" +
                        "2-Saber si ya inicio la inscripsiones.\n" +
                        "-¿No lo sabes?\n" +
                        "Acude a las oficinas del servicio social \n" +
                        "o \n" +
                        "habla a este telefono: 5804911" +
                        "3-Contar con los 5 creditos \n" +
                        "complementarios." +
                        "-En grado caso de no tener los 182 \n" +
                        "puntos completos estos seran \n" +
                        "completados con los 5 creditso.");
                break;
            case DatosDelServicioSocial:
                description = "Datos del Servicio Social";
                texto1=(TextView)findViewById(R.id.textViewInfo3);
                texto1.setText("Daros generales");
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
        titles.get(0).setText(title);
        titles.get(1).setText(description);
    }
}
