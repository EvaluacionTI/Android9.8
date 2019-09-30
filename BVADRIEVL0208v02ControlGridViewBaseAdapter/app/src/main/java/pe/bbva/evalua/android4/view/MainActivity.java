package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import pe.bbva.evalua.android4.controller.CCBaseAdaptarCustom;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private GridView oGvMostrarImagen;
    private static final String[] osImagen = new String[]{
        "Cells", "APX", "HOST", "Datio"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid_view);

        oGvMostrarImagen = (GridView) findViewById(R.id.id_gv_mostrar_imagen);

        oGvMostrarImagen.setAdapter(new CCBaseAdaptarCustom(this, osImagen));

        oGvMostrarImagen.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast oToast = Toast.makeText(getApplicationContext(), "Item " + ((TextView) view.findViewById(R.id.id_tv_texto_foto)).getText(), Toast.LENGTH_SHORT);
        oToast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        oToast.show();
    }
}
