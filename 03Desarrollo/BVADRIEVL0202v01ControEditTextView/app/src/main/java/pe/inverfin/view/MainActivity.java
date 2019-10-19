package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView oTextView;
    private EditText oEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Manipulando la información en la IU
        oTextView = findViewById(R.id.id_textViewArquitectura);
        oEditText = findViewById(R.id.id_editTextHostApx);

        oTextView.setText("Architectur :");
    }
}
