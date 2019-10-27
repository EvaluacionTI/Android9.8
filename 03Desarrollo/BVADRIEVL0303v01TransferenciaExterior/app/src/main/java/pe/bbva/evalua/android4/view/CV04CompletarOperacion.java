package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CV04CompletarOperacion extends AppCompatActivity {
    private Button oButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity04_completar_operacion);

        oButton = findViewById(R.id.id_btn_completar_transferencia);
    }
}
