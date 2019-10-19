package pe.inverfin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CvListView extends AppCompatActivity {

    private TextView oTvTitulo;
    private ListView oLvListaAlumnos;

    private String nombreAlumnos[]={"Esteban", "Alexander", "Illari", "Laskhmi", "Isabel", "Alex", "Luis", "Aesin", "Isabella", "Asori"};
    private String edadesAlumnos[]={"16", "15", "4", "3", "2", "1", "20", "27", "15", "17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_list_view);

        oTvTitulo = (TextView) findViewById(R.id.id_tv_titulo);
        oLvListaAlumnos = (ListView) findViewById(R.id.id_lv_lista_alumnos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_alumnos, nombreAlumnos);
        oLvListaAlumnos.setAdapter(adapter);

        oLvListaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                oTvTitulo.setText("La edad de " + oLvListaAlumnos.getItemAtPosition(position) + "es " + edadesAlumnos [position] + "años");
            }
        });
    }
}
