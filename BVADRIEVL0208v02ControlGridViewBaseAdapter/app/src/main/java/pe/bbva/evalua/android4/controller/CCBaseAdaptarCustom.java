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
    private String[] mobileValues = null;

    public CCBaseAdaptarCustom(Context poContext, String[] pasMobileValues){
        this.oContenxt = poContext;
        this.mobileValues = pasMobileValues;
    }

    public View getView(int piPosition, View poConvertView, ViewGroup poViewGroup){
        LayoutInflater inflater = (LayoutInflater) oContenxt
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//https://www.mkyong.com/android/android-gridview-example/
        View gridView;
        if (poConvertView == null) {

            gridView = new View(oContenxt);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_imagen_view, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(mobileValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.id_img_view_foto);

            String mobile = mobileValues[position];

            if (mobile.equals("Windows")) {
                imageView.setImageResource(R.drawable.windows_logo);
            } else if (mobile.equals("iOS")) {
                imageView.setImageResource(R.drawable.ios_logo);
            } else if (mobile.equals("Blackberry")) {
                imageView.setImageResource(R.drawable.blackberry_logo);
            } else {
                imageView.setImageResource(R.drawable.android_logo);
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
