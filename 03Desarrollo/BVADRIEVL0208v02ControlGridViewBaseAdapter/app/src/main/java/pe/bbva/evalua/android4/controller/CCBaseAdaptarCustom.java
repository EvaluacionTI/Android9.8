package pe.bbva.evalua.android4.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pe.bbva.evalua.android4.view.R;

public class CCBaseAdaptarCustom extends BaseAdapter {
    private Context oContenxt;
    private String[] saMobileValues = null;

    public CCBaseAdaptarCustom(Context poContext, String[] pasMobileValues){
        this.oContenxt = poContext;
        this.saMobileValues = pasMobileValues;
    }

    public View getView(int piPosition, View poConvertView, ViewGroup poViewGroup){
        LayoutInflater inflater = (LayoutInflater) oContenxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//https://www.mkyong.com/tutorials/android-tutorial/
        View gridView;
        if (poConvertView == null) {

            gridView = new View(oContenxt);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_imagen_view, null);

            // set value into textview
            TextView textView = (TextView) gridView.findViewById(R.id.id_tv_texto_foto);
            textView.setText(saMobileValues[piPosition]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.id_img_view_foto);

            String mobile = saMobileValues[piPosition];

            if (mobile.equals("ili01")) {
                imageView.setImageResource((R.drawable.ili01_20190101));
            } else if (mobile.equals("ili02")) {
                imageView.setImageResource(R.drawable.ili02_20190101);
            } else if (mobile.equals("ili03")) {
                imageView.setImageResource(R.drawable.ili03_20190101);
            } else if (mobile.equals("ili04")) {
                imageView.setImageResource(R.drawable.ili04_20190101);
            } else {
                imageView.setImageResource(R.drawable.ili05_20190101);
            }

        } else {
            gridView = (View) poConvertView;
        }
        return gridView;
    };

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
