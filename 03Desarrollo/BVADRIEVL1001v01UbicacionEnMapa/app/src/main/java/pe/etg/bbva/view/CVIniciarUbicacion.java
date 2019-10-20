package pe.etg.bbva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CVIniciarUbicacion extends AppCompatActivity {
    private Button oBtnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cviniciar_ubicacion);

        oBtnIniciar = (Button)findViewById(R.id.idBtnIniciarUbicacion);

        oBtnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oIntento = new Intent(CVIniciarUbicacion.this,CVMapsActivity.class);
                startActivity(oIntento);
            }
        });
    }
}
