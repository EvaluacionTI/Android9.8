package pe.inverfin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button oBtnUbicarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oBtnUbicarme=(Button)findViewById(R.id.btnUbicacion);

        oBtnUbicarme.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent oInten = new Intent(MainActivity.this,CVMapsActivityActual.class);
                startActivity(oInten);
            }
        });
    }
}
