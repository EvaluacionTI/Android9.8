package pe.etg.bbva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CVRegistroCanal extends AppCompatActivity  {
    private TextView oTv_usuario, oTv_fecha;
    private TextView oTv_codigo, oTv_abreviatua, oTv_descripcion;
    private Button oBtn_retornar, oBtn_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvregistro_canal);

        oBtn_retornar = findViewById(R.id.id_btn_retornar);
        oBtn_salir = findViewById(R.id.id_btn_salir);
        oTv_usuario = findViewById(R.id.id_tv_usuario);
        oTv_fecha = findViewById(R.id.id_tv_fecha_sistema);

        oTv_codigo = findViewById(R.id.id_et_codigo);
        oTv_abreviatua = findViewById(R.id.id_et_abreviatura);
        oTv_descripcion = findViewById(R.id.id_et_descripcion);

        Bundle oBundleTraerDatos = getIntent().getExtras();

        if (oBundleTraerDatos != null){
            oTv_usuario.setText(oBundleTraerDatos.getString("vUsuario"));
            oTv_fecha.setText(oBundleTraerDatos.getString("vFechaSistema"));

            oTv_codigo.setText(oBundleTraerDatos.getString("vCodigo"));
            oTv_abreviatua.setText(oBundleTraerDatos.getString("vAbreviatura"));
            oTv_descripcion.setText(oBundleTraerDatos.getString("vDescripcion"));
        }


        oBtn_retornar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent oIntentoVolver = new Intent(CVRegistroCanal.this, CVLoginAcceso.class);
                startActivity(oIntentoVolver);
            }
        });

        oBtn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si deseo salir de la aplicación desde una actividad. El cual retornar a la actividad
                // principal por medio del flag se usa para salir totalmente de la aplicación.
                Intent intent = new Intent(CVRegistroCanal.this, CVLoginAcceso.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT_APPLICATION", true);
                startActivity(intent);

                // Para cerrar un actividad

                finish(); // La cerramos.
            }
        });
    }


}
