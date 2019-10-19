package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText oEtPrimerValor, oEtSegundoValor;
    private TextView oTvResultado;
    private RadioButton oRbtnSumar, oRbtnRestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oEtPrimerValor = (EditText)findViewById(R.id.id_editText_primer_valor);
        oEtSegundoValor = (EditText)findViewById(R.id.id_editText_segundo_valor);
        oTvResultado = (TextView) findViewById(R.id.id_textView_resultado);
        oRbtnSumar = (RadioButton) findViewById(R.id.id_radioButton_sumar);
        oRbtnRestar = (RadioButton) findViewById(R.id.id_radioButton_restar);
    }

    public void calcularOperacion(View view) {
        int iValor1 = Integer.parseInt(oEtPrimerValor.getText().toString());
        int iValor2 = Integer.parseInt(oEtSegundoValor.getText().toString());
        int iResultado = 0;

        if (oRbtnSumar.isChecked()==true){
            iResultado = iValor1 + iValor2;
        }else{
            if (oRbtnRestar.isChecked()==true){
                iResultado = iValor1 - iValor2;
            }
        }

        oTvResultado.setText(Integer.toString(iResultado));

    }
}
