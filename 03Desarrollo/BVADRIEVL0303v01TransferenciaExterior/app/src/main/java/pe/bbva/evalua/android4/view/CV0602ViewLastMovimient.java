package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CV0602ViewLastMovimient extends AppCompatActivity {
    private EditText oEditTextBeneficiary, oEditTextNumberAccountBeneficiary, oEditTextReferenceBeneficiary;
    private EditText oEditTextTypeRace, oEditTextAmountComision, oEditTextAmountTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0602_view_last_movimient);

        oEditTextBeneficiary = findViewById(R.id.id_et_nombre_beneficiario);
        oEditTextNumberAccountBeneficiary = findViewById(R.id.id_et_numero_cuenta_beneficiario);
        oEditTextReferenceBeneficiary = findViewById(R.id.id_et_referencia_transferencia);
        oEditTextTypeRace = findViewById(R.id.id_et_type_rates);
        oEditTextAmountComision = findViewById(R.id.id_et_amount_comision);
        oEditTextAmountTransfer = findViewById(R.id.id_et_importe_transferir);

        //Inhabilitando entrada de datos
        oEditTextBeneficiary.setEnabled(false);
        oEditTextNumberAccountBeneficiary.setEnabled(false);
        oEditTextReferenceBeneficiary.setEnabled(false);
        oEditTextTypeRace.setEnabled(false);
        oEditTextAmountComision.setEnabled(false);
        oEditTextAmountTransfer.setEnabled(false);

        Bundle oBundleReceiveData = getIntent().getExtras();
        if (oBundleReceiveData != null){
            oEditTextBeneficiary.setText(oBundleReceiveData.getString("vBeneficiary"));
            oEditTextNumberAccountBeneficiary.setText(oBundleReceiveData.getString("vNumberAccountBeneficiary"));
            oEditTextTypeRace.setText(oBundleReceiveData.getString("vTypeRace"));
            oEditTextAmountComision.setText(oBundleReceiveData.getString("vAmountComision"));
            oEditTextReferenceBeneficiary.setText(oBundleReceiveData.getString("vReferenceBeneficiary"));
            oEditTextAmountTransfer.setText(oBundleReceiveData.getString("vAmountTransfer"));
        }

    }
}
