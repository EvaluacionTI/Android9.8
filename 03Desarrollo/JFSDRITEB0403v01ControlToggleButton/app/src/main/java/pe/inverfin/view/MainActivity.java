package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton oToggleButtonEncendido;
    private Button oButtonProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oToggleButtonEncendido = (ToggleButton) findViewById(R.id.id_toggleButton_on_off);
        oButtonProcesar = (Button) findViewById(R.id.id_button_procesar);

        oButtonProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (oToggleButtonEncendido.isChecked()==true){
                    oToggleButtonEncendido.setChecked(false);
                    oToggleButtonEncendido.setTextOn("Motor Encendido");
                }else{
                    oToggleButtonEncendido.setChecked(true);
                    oToggleButtonEncendido.setTextOff("Motor Apagado");
                }
            }
        });
    }
}
