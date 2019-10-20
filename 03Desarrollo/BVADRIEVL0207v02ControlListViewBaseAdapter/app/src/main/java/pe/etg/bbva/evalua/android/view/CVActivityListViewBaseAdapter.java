package pe.etg.bbva.evalua.android.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.etg.bbva.evalua.android.controller.CCBaseAdapterCustom;
import pe.etg.bbva.evalua.android.entity.CERowItemUserFoto;

public class CVActivityListViewBaseAdapter extends AppCompatActivity implements OnItemClickListener{
    private ListView oLvUsuarios;
    private String asUsuario[] = {"User 1", "User 2", "User 3", "User 4", "User 5", "User 6", "User 7", "User 8", "User 9", "User 10"};
    private int aiFotos[] = {R.drawable.usuario_1, R.drawable.usuario_2, R.drawable.usuario_3, R.drawable.usuario_4, R.drawable.usuario_5, R.drawable.usuario_6, R.drawable.usuario_7, R.drawable.usuario_8, R.drawable.usuario_9, R.drawable.usuario_10};
    private List<CERowItemUserFoto> oCEListUserFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvlist_view_base_adapter);

        oCEListUserFoto = new ArrayList<CERowItemUserFoto>();
        for (int i=0; i<asUsuario.length; i++){
            CERowItemUserFoto oUsuario = new CERowItemUserFoto(asUsuario[i],aiFotos[i]);
            oCEListUserFoto.add(oUsuario);
        }

        oLvUsuarios = (ListView) findViewById(R.id.id_lv_activity_mostrar_usuarios);
        CCBaseAdapterCustom oCCUserAdapter = new CCBaseAdapterCustom(getApplicationContext(), oCEListUserFoto);
        oLvUsuarios.setAdapter(oCCUserAdapter);
        oLvUsuarios.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast oToast = Toast.makeText(getApplicationContext(), "Item " + (position+1) + " : " + oCEListUserFoto.get(position), Toast.LENGTH_SHORT);
        oToast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        oToast.show();
    }
}
