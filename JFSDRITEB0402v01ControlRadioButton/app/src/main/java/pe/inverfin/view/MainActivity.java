package pe.inverfin.view;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText oEtPrimerValor, oEtSegundoValor;
    private RadioButton oRBtnSumar, oRBtnRestar;
    private TextView oTvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oEtPrimerValor = (EditText) findViewById(R.id.id_editText_primer_valor);
        oEtSegundoValor = (EditText) findViewById(R.id.id_editText_segundo_valor);
        oRBtnSumar = (RadioButton) findViewById(R.id.id_radioButton_sumar);
        oRBtnRestar = (RadioButton) findViewById(R.id.id_radioButton_restar);
        oTvResultado = (TextView) findViewById(R.id.id_textView_resultado);
    }

    public void calcularOperacion(View view) {
        int iResultado = 0;
        int iValor1 = Integer.parseInt(oEtPrimerValor.getText().toString());
        int iValor2 = Integer.parseInt(oEtSegundoValor.getText().toString());

        if (oRBtnSumar.isChecked()==true){
            iResultado = iValor1 + iValor2;
        }else{
            if (oRBtnRestar.isChecked()==true){
                iResultado = iValor1 - iValor2;
            }
        }

        oTvResultado.setText(Integer.toString(iResultado));
    }
}
