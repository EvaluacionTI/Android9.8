package pe.etg.bbva.evalua.android.view.bvadrievl1602v01mostrarpdf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pe.etg.bbva.evalua.android.view.CV020v01SeleccionarComboBox;

public class CV0201v01ElegirArchivo extends Activity {
    private Button oButtonElegirArchivo;
    private Spinner oSpinnerElegirArchivo;
    private String[] aStringTipo;
    private List<String> oListaElegirArchivo;
    private ArrayAdapter<String> oComboAdapterListArchivos;

    private static int VALOR_RETORNO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0201v01_elegir_archivo);

        oButtonElegirArchivo = findViewById(R.id.id_btn_elegir_archivo);
        oSpinnerElegirArchivo = findViewById(R.id.id_spinner_elegir_archivos);
        oSpinnerElegirArchivo.setOnItemSelectedListener(new CV020v01SeleccionarComboBox());

        oListaElegirArchivo = new ArrayList<>();
        aStringTipo = new String[] {"Todo", "Audio", "Video", "Imagen", "Texto", "PDF"};
        Collections.addAll(oListaElegirArchivo, aStringTipo);
        oComboAdapterListArchivos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, oListaElegirArchivo);
        oSpinnerElegirArchivo.setAdapter(oComboAdapterListArchivos);

    }

    public void mostrarTipoArchivo(View poView){
        Intent oIntento = new Intent(Intent.ACTION_VIEW);

            // : Seleccionar todos los archivos
            //audio : solo archivos de audio mp3, wav
            //video : solo archivos video
            //image : solo archivo imagen
            //text/plain: solo archivos de texto plano
        String sDirectorioBaseAbsolute = Environment.getExternalStorageDirectory().getAbsolutePath();
        File oFile = new File(sDirectorioBaseAbsolute + "/video","*.");

        Spinner sp =	(Spinner)findViewById(R.id.id_spinner_elegir_archivos);
        String sSelecctionTipo = oSpinnerElegirArchivo.getSelectedItem().toString();
        int nPosition = sp.getSelectedItemPosition();
        Toast.makeText(getApplicationContext(), "Seleccionado :" + sSelecctionTipo, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Seleccionado Position:" + nPosition, Toast.LENGTH_LONG).show();
        startActivityForResult(Intent.createChooser(oIntento,"Seleccione Archivo : "), VALOR_RETORNO);

/*        switch (sSelecctionTipo){
            case "Todo":
                break;
            case "Audio":
                break;
            case "Video":
                break;
            case "Imagen":
                break;
            case "Texto":
                break;
            case "PDF":
                break;
        }
        oIntento.setType(sSelecctionTipo+"/*");
        startActivityForResult(Intent.createChooser(oIntento,"Seleccione Archivo : "), VALOR_RETORNO);*/
    }
}
