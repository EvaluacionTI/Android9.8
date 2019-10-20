package pe.etg.bbva.evalua.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CV0301v01SpinnerPorCodigo extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner oSpinnerPaises;
    private String[] aStringPaises;
    private List<String> oListaPaises;
    private ArrayAdapter<String> oComboAdapterPaises;
    private String sNombrePais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0301v01_spinner_por_codigo);

        // Procedimiento
        // 1. Cargar datos desde array

        oSpinnerPaises = (Spinner) findViewById(R.id.id_spinner_paises);

        // 2. Implemento el listener
        oSpinnerPaises.setOnItemSelectedListener(this);

        // 3. Convertir el list en ArrayList
        oListaPaises = new ArrayList<>();

        // 4. Arreglo con nombre de Paises
        aStringPaises = new String[] {"Perú", "Chile", "Argentina", "Colombia", "Venezuela", "Turquía"};

        // 5. Agrego el arreglo de paises a la lista
        Collections.addAll(oListaPaises, aStringPaises);

        // 6. Implemento el adapter
        oComboAdapterPaises = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, oListaPaises);

        // 7. Cargar los datos en el spinner
        oSpinnerPaises.setAdapter(oComboAdapterPaises);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.id_spinner_paises:
                sNombrePais = aStringPaises[position];
                Toast.makeText(this, "Name of Pais: " + sNombrePais, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
