package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CV02SimularOperacion extends AppCompatActivity {
    private Button oButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_simular_operacion);

        oButton = findViewById(R.id.id_btn_simular_transferencia);
    }
}
