package pe.etg.bbva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CVLoginAcceso extends AppCompatActivity implements View.OnClickListener {

    private EditText oUsuario;
    private EditText oClave;
    private Button oBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvlogin_acceso);

        // Para salir utilizando el boton salir de la segunda actividad.
        if (getIntent().getBooleanExtra("EXIT_APPLICATION", false)){
            finish();
        }

        oUsuario = findViewById(R.id.id_et_usuario);
        oClave = findViewById(R.id.id_et_password);

        oBoton = findViewById(R.id.id_btn_ingresar);
        oBoton.setOnClickListener(this);

    }

    @Override
    public void onClick(View poV){
        
        Date oFechaSistema = new Date();
        SimpleDateFormat oFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String sFechaSistema = oFormatoFecha.format(oFechaSistema);

        if (poV.getId() == R.id.id_btn_ingresar){
            Intent oIntento = new Intent(this, CVRegistroCanal.class);

            oIntento.putExtra("vFechaSistema",sFechaSistema);
            oIntento.putExtra("vUsuario",oUsuario.getText().toString());
            oIntento.putExtra("vCodigo", "WEB");
            oIntento.putExtra("vAbreviatura", "CICLO 2018");
            oIntento.putExtra("vDescripcion", "MATRICULA");

            startActivity(oIntento);
        }
    }
}
