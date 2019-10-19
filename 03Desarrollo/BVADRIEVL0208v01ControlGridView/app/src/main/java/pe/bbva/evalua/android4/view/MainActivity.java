package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView oGVListNumber;
    private static final String[] osNumbers = new String[]{
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oGVListNumber = (GridView) findViewById(R.id.id_gv_list_numbers);

        ArrayAdapter<String> oaAdapter = new ArrayAdapter<>(this, R.layout.activity_main, R.id.id_tv_mostrar, osNumbers);
        oGVListNumber.setAdapter(oaAdapter);
        oGVListNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View poView, int i, long l) {
                Toast.makeText(getApplicationContext(),((TextView) poView).getText(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
