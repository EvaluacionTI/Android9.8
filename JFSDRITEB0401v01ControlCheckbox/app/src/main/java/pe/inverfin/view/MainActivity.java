package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView oTextView;
    private CheckBox oCheckBoxTeb, oCheckBoxDaw, oCheckBoxDbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oCheckBoxTeb = (CheckBox) findViewById(R.id.id_checkBox_teb);
        oCheckBoxDaw = (CheckBox) findViewById(R.id.id_checkBox_daw);
        oCheckBoxDbr = (CheckBox) findViewById(R.id.id_checkBox_dbr);

        oTextView = (TextView) findViewById(R.id.id_textView_resultCredit);

    }

    public void calcularCreditos(View view) {
        int iTotalCreditos = 0;

        if (oCheckBoxTeb.isChecked()){
            iTotalCreditos = iTotalCreditos + 4;
        }

        if (oCheckBoxDaw.isChecked()){
            iTotalCreditos = iTotalCreditos + 5;
        }

        if (oCheckBoxDbr.isChecked()){
            iTotalCreditos = iTotalCreditos + 3;
        }

        oTextView.setText(Integer.toString(iTotalCreditos));
    }
}
