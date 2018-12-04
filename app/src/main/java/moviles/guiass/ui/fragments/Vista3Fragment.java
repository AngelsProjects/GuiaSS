package moviles.guiass.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import moviles.guiass.ui.GeneralDataActivity;
import moviles.guiass.ui.InformationActivity;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.NextStepsActivity;
import moviles.guiass.ui.R;
import moviles.guiass.ui.StepByStepActivity;
import moviles.guiass.ui.WhereToDoActivity;
import moviles.guiass.ui.lateralmenu.MenuSliteActivity;
import moviles.guiass.ui.serviceDocuments.CartaAsignacion;
import moviles.guiass.ui.serviceDocuments.CartaCompromiso;
import moviles.guiass.ui.serviceDocuments.SolicitudServicio;
import moviles.guiass.ui.serviceDocuments.TarjetaControl;

import static moviles.guiass.Enum.MenuOptionsEnum.SolicitudServicio;
import static moviles.guiass.Enum.MenuOptionsEnum.TarjetaControl;
import static moviles.guiass.Enum.MenuOptionsEnum.CartaAsignacion;
import static moviles.guiass.Enum.MenuOptionsEnum.CartaCompromiso;

public class Vista3Fragment extends Fragment implements View.OnClickListener{
    private NavigationView navigationView;
    @BindViews({R.id.btn_cc, R.id.btn_ca, R.id.btn_ss, R.id.btn_tc})
    List<Button> btnsInfo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vista3, container, false);
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

        // realizamos un for para asignarle a cada boton un onClickListener
        // ya asinados por la lista que se realizo antes en butterknife
        // y etse nos servira para escuchar el clicka de cada boton
        // se le envia como parametro una vista en etse caso usamos la palabra reservada this
        // que significa esto o esta clase en la que te encuentras actualmente ya que esta clase es
        //una vista se puede enviar sin problema alguna
        for (Button btn : btnsInfo) {
            btn.setOnClickListener(this);
        }

        // ya que estamos dentro del metodo onclick realizamos una comparacion para ver desde
        // que boton estamos presionando
        switch (v.getId()) {

            //en cualquiera de los casos agrega al buldle un parametro con su respectivo valor
            // hay distintos modos de enviar parametros en este caso sera una variable entera por ello
            // se usa el metodo putInt... en cado caso de ser un string seria putString e igual para
            // cualquier otro tipo de dato
            // para ello se hace lo siguiente bundle.putInt("NOMBRE_DEL_PARAMETRO_A_ENVIAR", VALOR_DEL_PARAMETRO);
            case R.id.btn_ss:
                intent = new Intent(getActivity(), SolicitudServicio.class);
                getActivity().startActivity(intent);
                bundle.putInt("InfoOption", SolicitudServicio.getValue());
                break;
            case R.id.btn_tc:
                intent = new Intent(getActivity(), TarjetaControl.class);
                getActivity().startActivity(intent);
                bundle.putInt("InfoOption",TarjetaControl.getValue());
                break;
            case R.id.btn_ca:
                intent = new Intent(getActivity(), CartaAsignacion.class);
                getActivity().startActivity(intent);
                bundle.putInt("InfoOption", CartaAsignacion.getValue());
                break;
            case R.id.btn_cc:
                intent = new Intent(getActivity(), CartaCompromiso.class);
                getActivity().startActivity(intent);
                bundle.putInt("InfoOption", CartaCompromiso.getValue());
                break;

            default:
                intent = new Intent(getActivity(), SolicitudServicio.class);
                break;
        }
        // Con nuestra variable intent accedemos a su metodo putExtras para asignarle eseos parametros
        //cpon variables que ya se les asigno anteriormente
        intent.putExtras(bundle);

        // se inicializa el nuevo activity
        startActivity(intent);
    }
}
