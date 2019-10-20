package pe.etg.bbva.evalua.android.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.etg.bbva.evalua.android.entity.CERowItemUserFoto;
import pe.etg.bbva.evalua.android.view.R;

public class CCBaseAdapterCustom extends BaseAdapter {
    private Context oCntx;
    List<CERowItemUserFoto> oCEListRowItem;

    public CCBaseAdapterCustom(Context poCntx, List<CERowItemUserFoto> poListRow){
        this.oCntx = poCntx;
        this.oCEListRowItem = poListRow;
    }

    @Override
    public int getCount() {

        return oCEListRowItem.size();
    }

    @Override
    public Object getItem(int position) {
        return oCEListRowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return oCEListRowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CEUserFoto oCEUserFoto = null;
        LayoutInflater oLayoutInflater = (LayoutInflater) oCntx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = oLayoutInflater.inflate(R.layout.list_view_base_adapter,null);
            oCEUserFoto = new CEUserFoto();
            oCEUserFoto.tvUsuario = (TextView) convertView.findViewById(R.id.id_tv_usuario);
            oCEUserFoto.ivFoto = (ImageView) convertView.findViewById(R.id.id_iv_foto_usuario);
            convertView.setTag(oCEUserFoto);
        }else{
            oCEUserFoto = (CEUserFoto) convertView.getTag();
        }

        CERowItemUserFoto oRowItem = (CERowItemUserFoto) getItem(position);
        oCEUserFoto.tvUsuario.setText(oRowItem.getUsuario());
        oCEUserFoto.ivFoto.setImageResource(oRowItem.getFoto());

        return convertView;
    }

    private class CEUserFoto{
        ImageView ivFoto;
        TextView tvUsuario;
    }
}
