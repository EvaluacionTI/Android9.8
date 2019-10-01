package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pe.inverfin.entity.CECanal;
import pe.inverfin.utility.CUTakeCadenas;

public class MainActivity extends AppCompatActivity {
    private CECanal oCECanal;
    private CUTakeCadenas oCUCadenas = null;
    private EditText oEtCodigo, oEtAbreviatura, oEtDescripcion;
    private TextView oTextView;
    private Button oButtonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oEtCodigo = (EditText) findViewById(R.id.id_editText_Codigo);
        oEtAbreviatura = (EditText) findViewById(R.id.id_editText_Abreviatura);
        oEtDescripcion = (EditText) findViewById(R.id.id_editText_Descripcion);
        oTextView = findViewById(R.id.id_textView_Concatenar);

        oButtonEnviar = (Button) findViewById(R.id.id_button_enviar);

        //Evento
        oButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCadena();
            }
        });
    }

    public  void mostrarCadena(){
        oCECanal = new CECanal();
        oCUCadenas = new CUTakeCadenas();

        oCECanal.setCodigo(oEtCodigo.getText().toString());
        oCECanal.setAbreviatura(oEtAbreviatura.getText().toString());
        oCECanal.setDescripcion(oEtDescripcion.getText().toString());

        String sConcatenar =oCUCadenas.getConcatenarCadena(oCECanal);
        oTextView.setText(sConcatenar);
    }
}
