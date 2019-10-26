package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CV03AceptarOperacion extends AppCompatActivity {
    private Button oButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity03_aceptar_operarion);

        oButton = findViewById(R.id.id_btn_aceptar_transferencia);
    }
}
