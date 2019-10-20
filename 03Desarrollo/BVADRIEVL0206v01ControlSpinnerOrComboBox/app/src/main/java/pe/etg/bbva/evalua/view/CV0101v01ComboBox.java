package pe.etg.bbva.evalua.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CV0101v01ComboBox extends AppCompatActivity {

    private Button oButtonSpinnerSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0101v01_combo_box);

        oButtonSpinnerSimple = findViewById(R.id.id_button_spinner_simple);

    }

    public void spinnerSimple(View poView){
        if (poView.getId() == R.id.id_button_spinner_simple){
            Toast.makeText(getApplicationContext(), "A iniciado otra actividad " + poView.getId() , Toast.LENGTH_LONG).show();
            Intent oSpinnerSimple = new Intent(this, CV0201v01SpinnerFormatSimple.class);
            startActivity(oSpinnerSimple);
        }else{
            Toast.makeText(getApplicationContext(), "Actividad no identificada" + poView.getId() , Toast.LENGTH_LONG).show();
        }

    }

    public void spinnerCodigo(View poView){
        if (poView.getId() == R.id.id_button_spinner_codigo){
            Toast.makeText(getApplicationContext(), "A iniciado otra actividad en context " + getApplicationContext() , Toast.LENGTH_LONG).show();
            Intent oSpinnerCombo = new Intent(this, CV0301v01SpinnerPorCodigo.class);
            startActivity(oSpinnerCombo);
        }else{
            Toast.makeText(getApplicationContext(), "Actividad no identificada" + poView.getId() , Toast.LENGTH_LONG).show();
        }
    }
}
