package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import pe.inverfin.entity.CEAlumno;
import pe.inverfin.utility.CUArmaCadena;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private CUArmaCadena oCUCadena;
    private CEAlumno oCEAlumno;
    private TextView oTvMostrar;
    private EditText oEtCodigAlumno, oEtNumeroDNI, oEtApellidoPaterno, oEtApellidoMaterno;
    private EditText oEtPrimerNombre, oEtSegundoNombre, oEtTercerNombre;
    private Button oButtonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oEtCodigAlumno = (EditText) findViewById(R.id.id_et_codigo_alumno);
        oEtNumeroDNI= (EditText)findViewById(R.id.id_et_dni);
        oEtApellidoPaterno= (EditText)findViewById(R.id.id_et_apellido_paterno);
        oEtApellidoMaterno= (EditText)findViewById(R.id.id_et_apellido_materno);
        oEtPrimerNombre= (EditText)findViewById(R.id.id_et_primer_nombre);
        oEtSegundoNombre= (EditText)findViewById(R.id.id_et_segundo_nombre);
        oEtTercerNombre= (EditText)findViewById(R.id.id_et_tercer_nombre);

        oTvMostrar = (TextView)findViewById(R.id.id_tv_mostrar_cadena);
        oButtonEnviar = (Button)findViewById(R.id.id_btn_enviar);
        oButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCadena();
            }
        });
    }

    public void mostrarCadena() {
        oCEAlumno = new CEAlumno();
        oCUCadena = new CUArmaCadena();

        oCEAlumno.setCodigoAlumno(oEtCodigAlumno.getText().toString());
        oCEAlumno.setNumeroDNI(oEtNumeroDNI.getText().toString());
        oCEAlumno.setApellidoPaterno(oEtApellidoPaterno.getText().toString());
        oCEAlumno.setApellidoMaterno(oEtApellidoMaterno.getText().toString());
        oCEAlumno.setPrimerNombre(oEtPrimerNombre.getText().toString());
        oCEAlumno.setSegundoNombre(oEtSegundoNombre.getText().toString());
        oCEAlumno.setTercerNombre(oEtTercerNombre.getText().toString());

        Log.i(TAG, oCEAlumno.toString());
        Log.i(TAG, oCUCadena.toString());
        oTvMostrar.setText(oCUCadena.concatenarCadena(oCEAlumno));
    }

}
