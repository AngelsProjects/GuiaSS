package moviles.guiass.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import moviles.guiass.ui.R;
import moviles.guiass.ui.lateralmenu.MenuSliteActivity;

import static moviles.guiass.Enum.MenuOptionsEnum.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private NavigationView navigationView;
    // se hacen binding por medio de butterknife a los objetos de la vista XML en este caso a los TEXTVIEW'S
    // para ello se les asignan mediante los ID's txt_infoTitle, txt_infoDesc que ya se debieron haber asignado en el XML
    @BindViews({R.id.btn_req, R.id.btn_dh, R.id.btn_dss, R.id.btn_pp, R.id.btn_ps, R.id.btn_menu})
    List<Button> btnsInfo;


    // El metodo onCreate se inicializa para crear todos los objetos o darles algun valor
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // se manda a llamar la funcioin super que en definicion es como un constructor que guarda la instancia del estado actual
        super.onCreate(savedInstanceState);

        // se asigna la vista al Activity en este caso estamos en el activity InformationActivity
        // y se  le esta asignando la vista del siguiente repositorio
        // R.layout.activity_information
        // que en definicion por carpetas: res -> layout -> activity_main.xml
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //damos por hecho que haremos binding a los objetos ya declarados anteriormente para este Activity
        ButterKnife.bind(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // realizamos un for para asignarle a cada boton un onClickListener
        // ya asinados por la lista que se realizo antes en butterknife
        // y etse nos servira para escuchar el clicka de cada boton
        // se le envia como parametro una vista en etse caso usamos la palabra reservada this
        // que significa esto o esta clase en la que te encuentras actualmente ya que esta clase es
        //una vista se puede enviar sin problema alguna
        for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }


    }

    // aqui se encuentra el listener que se les asigno a los botones anteriormente
    @Override
    public void onClick(View v) {
        // Con la clase o metodo Intent podremos mandar a llamar a otro activity
        // para ello se crea un intent en el cual recive dos parametros
        // 1: el contexto del paquete de donde se enviara en este caso es desde la clase MainActivity.this el cual es la clase del activity
        // 2: la clase que del activity que quieres mandar a llamar en etse claso InformationActivity.class para acceder a su clase
        Intent intent;

        // creamos una variable bundle para almacenar las variables que le queremos enviar al activity a invocar
        Bundle bundle = new Bundle();

        // ya que estamos dentro del metodo onclick realizamos una comparacion para ver desde
        // que boton estamos presionando
        switch (v.getId()) {

            //en cualquiera de los casos agrega al buldle un parametro con su respectivo valor
            // hay distintos modos de enviar parametros en este caso sera una variable entera por ello
            // se usa el metodo putInt... en cado caso de ser un string seria putString e igual para
            // cualquier otro tipo de dato
            // para ello se hace lo siguiente bundle.putInt("NOMBRE_DEL_PARAMETRO_A_ENVIAR", VALOR_DEL_PARAMETRO);
            case R.id.btn_menu:
                intent = new Intent(MainActivity.this, MenuSliteActivity.class);
                bundle.putInt("InfoOption", RequisitosPrevios.getValue());
                break;
            case R.id.btn_req:
                intent = new Intent(MainActivity.this, InformationActivity.class);
                bundle.putInt("InfoOption", RequisitosPrevios.getValue());
                break;
            case R.id.btn_dh:
                intent = new Intent(MainActivity.this, WhereToDoActivity.class);
                bundle.putInt("InfoOption", DondeHacerlo.getValue());
                break;
            case R.id.btn_dss:
                intent = new Intent(MainActivity.this, GeneralDataActivity.class);
                bundle.putInt("InfoOption", DatosDelServicioSocial.getValue());
                break;
            case R.id.btn_pp:
                intent = new Intent(MainActivity.this, StepByStepActivity.class);
                break;
            case R.id.btn_ps:
                intent = new Intent(MainActivity.this, NextStepsActivity.class);
                bundle.putInt("InfoOption", PasosSiguientes.getValue());
                break;
            default:
                intent = new Intent(MainActivity.this, InformationActivity.class);
                break;
        }
        // Con nuestra variable intent accedemos a su metodo putExtras para asignarle eseos parametros
        //cpon variables que ya se les asigno anteriormente
        intent.putExtras(bundle);

        // se inicializa el nuevo activity
        startActivity(intent);
    }


}
