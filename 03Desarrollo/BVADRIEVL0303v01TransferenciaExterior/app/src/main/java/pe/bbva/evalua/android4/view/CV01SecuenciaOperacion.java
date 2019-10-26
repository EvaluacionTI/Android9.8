package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CV01SecuenciaOperacion extends AppCompatActivity implements View.OnClickListener{
    private Button oButtonSimular, oButtonAceptar, oButtonCompletar;
    private Button oButtonQueryById, oButtonQueryLastMoviment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_secuencia_operacion);

        oButtonSimular = findViewById(R.id.id_button_simular);
        oButtonAceptar = findViewById(R.id.id_button_aceptar);
        oButtonCompletar = findViewById(R.id.id_button_completar);
        oButtonQueryById = findViewById(R.id.id_button_query_by_id);
        oButtonQueryLastMoviment = findViewById(R.id.id_button_query_last_moviment);

        oButtonSimular.setOnClickListener(this);
        oButtonAceptar.setOnClickListener(this);
        oButtonCompletar.setOnClickListener(this);
        oButtonQueryById.setOnClickListener(this);
        oButtonQueryLastMoviment.setOnClickListener(this);

    }

    @Override
    public void onClick(View poView) {
        if (poView.getId()==R.id.id_button_simular){
            Intent oIntento = new Intent(this, CV02SimularOperacion.class);
            startActivity(oIntento);
        }else if (poView.getId()==R.id.id_button_aceptar){
            Intent oIntento = new Intent(this, CV03AceptarOperacion.class);
            startActivity(oIntento);
        }else if (poView.getId()==R.id.id_button_completar){
            Intent oIntento = new Intent(this, CV04CompletarOperacion.class);
            startActivity(oIntento);
        }else if (poView.getId() == R.id.id_button_query_by_id){
            Intent oIntento = new Intent(this, CV05ConsultaById.class);
            startActivity(oIntento);
        }else if (poView.getId() == R.id.id_button_query_last_moviment){
            Intent oIntento = new Intent(this, CV06ConsultLastMovimient.class);
            startActivity(oIntento);
        }
    }
}
