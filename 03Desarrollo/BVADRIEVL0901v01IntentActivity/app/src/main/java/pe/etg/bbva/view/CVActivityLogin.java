package pe.etg.bbva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CVActivityLogin extends AppCompatActivity implements View.OnClickListener {

    private Button oBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvlogin);

        oBoton = findViewById(R.id.id_btn_ingresar);
        oBoton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.id_btn_ingresar){
            Intent oIntento = new Intent(this, CVRegistroCanal.class);
            startActivity(oIntento);
        }
    }
}
