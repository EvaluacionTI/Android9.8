package pe.etg.bbva.evalua.android.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class CV020v01SeleccionarComboBox implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(), "Item is " +
                parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
