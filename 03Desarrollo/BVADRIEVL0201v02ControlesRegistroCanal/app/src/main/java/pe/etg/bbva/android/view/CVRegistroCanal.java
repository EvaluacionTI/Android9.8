package pe.etg.bbva.android.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pe.etg.bbva.android.entity.CECanal;
import pe.etg.bbva.android.utility.CUConvertir;
import pe.etg.bbva.view.R;

public class CVRegistroCanal extends AppCompatActivity {
    private TextView oTvTrama, oTvTramaColor, oTvStyleLetra;
    private EditText oEtCodigo, oEtAbreviatura, oEtDescripcion;
    private CECanal oCECanal;
    private CUConvertir oCUtilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvregistro_canal);

        oEtCodigo = (EditText) findViewById(R.id.id_et_codigo);
        oEtAbreviatura = (EditText) findViewById(R.id.id_et_abreviatura);
        oEtDescripcion = (EditText) findViewById(R.id.id_et_descripcion);

        oTvTrama = findViewById(R.id.id_tv_trama_canal);
        oTvTramaColor = findViewById(R.id.id_tv_concatenar_color);
        oTvStyleLetra = findViewById(R.id.id_tv_style_face);

    }

    public void enviarRegistro(View poView){
        oCUtilidad = new CUConvertir();
        oCECanal = new CECanal();

        // 1. Asigna los datos de la pantalla a un objecto
        oCECanal.setCodigo(oEtCodigo.getText().toString());
        oCECanal.setAbrevitura(oEtAbreviatura.getText().toString());
        oCECanal.setDescripcion(oEtDescripcion.getText().toString());

        // 2. Asigna color de fondo a las cajas de salida
        oTvTrama.setBackgroundColor(Color.GRAY);
        //oTvTramaColor.setBackgroundColor(Color.MAGENTA);

        // 3. Asigna los datos concatenados de manera simple
        oTvTrama.setText(oCUtilidad.concatenarTexto(oCECanal));

        // 4. Asigna color a cada atributo de la entidad
        oTvTramaColor.setText(oCUtilidad. colorTextoSeparador(oCECanal, "|"), TextView.BufferType.SPANNABLE);

        // 5. Asigna style de letra a cada atributo de la entidad
        oTvStyleLetra.setText(oCUtilidad.tipoLetraSeparador(oCECanal, "|"), TextView.BufferType.SPANNABLE);
    }

}
