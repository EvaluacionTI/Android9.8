package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MOLOG = "EVL-MainActivity";
    private TextView oTv;
    private Button oBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // La actividad esta ejecutandose
        Log.i(MOLOG, "onCreate(): Actividad ejecutandose");
        Toast.makeText(this,"method : onCreate()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        // La actividad esta a punto de hacerse visible
        Log.d(MOLOG, "onStart(): Actividad a punto de hacerse visible");
        Toast.makeText(this,"method : onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        // La actividad se ha vuelto visible (ahora se reanuda)
        Log.v(MOLOG, "onResume(): La actividad se ha vuelto visible");
        Toast.makeText(this,"method : onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        // Enforcarse en otra actvidad (esta actividad esta a punto de ser detenida)
        Log.w(MOLOG, "onPause(): Enfocarse en otra actividad");
        Toast.makeText(this,"method : onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        // La actividad ya no esta visible, ahora esta detenido
        Log.e(MOLOG, "onStop(): La actividad ya no esta visible, ahora esta detenido");
        Toast.makeText(this,"method : onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // La actividad esta a punto de ser destruida
        Log.w(MOLOG, "onDestroy(): La actividad esta a punto de ser destruida");
        Toast.makeText(this,"method : onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
