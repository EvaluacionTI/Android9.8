package pe.etg.bbva.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pe.etg.bbva.entidad.CECanal;
import pe.etg.bbva.entidad.CEConstanteColor;
import pe.etg.bbva.utilidad.CUConvertir;

public class CVRegistroCanal extends AppCompatActivity {
    private TextView oTvTrama;
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

    }

    public void enviarRegistro(View poView){
        oCUtilidad = new CUConvertir();

        oCECanal = new CECanal();

        oCECanal.setCodigo(oEtCodigo.getText().toString());
        oCECanal.setAbrevitura(oEtAbreviatura.getText().toString());
        oCECanal.setDescripcion(oEtDescripcion.getText().toString());

        // Asignando fondo de color
        oTvTrama.setBackgroundColor(Color.GRAY);

        // Resultado del color a cada texto
       // String sCadena = oCUtilidad.armarTramaHtml(oCECanal);
     //   oTvTrama.setText(oCUtilidad.getFormatoColorHtml(sCadena));
   //     oTvTrama.setText(oCUtilidad.getFormatoColorHtml(sCadena), TextView.BufferType.SPANNABLE);

        //String sCadena = oCUtilidad.armarTramaSpan(oCECanal);

/*        int colorBlue = getResources().getColor(R.color.colorBlue);
        String text = getString(R.string.tv_codigo);
        SpannableString spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(colorBlue), 0, text.length(), 0);
        oTvTrama.setText(spannable);*/
        oTvTrama.setText(oCUtilidad.getFormateColorSpan(oCECanal.getAbrevitura(),1));
    }

}
