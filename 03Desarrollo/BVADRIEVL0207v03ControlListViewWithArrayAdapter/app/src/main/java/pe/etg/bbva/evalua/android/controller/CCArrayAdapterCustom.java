package pe.etg.bbva.evalua.android.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.etg.bbva.evalua.android.entity.CERowItemUserFoto;
import pe.etg.bbva.evalua.android.view.R;
public class CCArrayAdapterCustom extends ArrayAdapter<CERowItemUserFoto> {

    Context oCntx;

    public CCArrayAdapterCustom(Context context, int resourceId, List<CERowItemUserFoto> items){
        super(context, resourceId, items);
        this.oCntx = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CEUserFoto oCEUserFoto = null;
        LayoutInflater oLayoutInflater = (LayoutInflater) oCntx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = oLayoutInflater.inflate(R.layout.lv0101v01mostrarlist,null);
            oCEUserFoto = new CEUserFoto();
            oCEUserFoto.tvUsuario = (TextView) convertView.findViewById(R.id.id_tv_usuario);
            oCEUserFoto.tvDescripcion = convertView.findViewById(R.id.id_tv_desc);
            oCEUserFoto.ivFoto = (ImageView) convertView.findViewById(R.id.id_iv_foto_usuario);
            convertView.setTag(oCEUserFoto);
        }else{
            oCEUserFoto = (CEUserFoto) convertView.getTag();
        }

        CERowItemUserFoto oRowItem = (CERowItemUserFoto) getItem(position);
        oCEUserFoto.tvUsuario.setText(oRowItem.getUsuario());
        oCEUserFoto.tvDescripcion.setText(oRowItem.getDescripcion());
        oCEUserFoto.ivFoto.setImageResource(oRowItem.getFoto());

        return convertView;
    }

    private class CEUserFoto{
        ImageView ivFoto;
        TextView tvUsuario;
        TextView tvDescripcion;
    }
}
