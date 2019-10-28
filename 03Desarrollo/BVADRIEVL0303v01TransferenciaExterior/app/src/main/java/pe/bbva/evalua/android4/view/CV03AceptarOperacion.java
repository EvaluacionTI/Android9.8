package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import pe.bbva.evalua.android4.entidad.CEAcceptation;
import pe.bbva.evalua.android4.entidad.CESimulation;

public class CV03AceptarOperacion extends AppCompatActivity {
    private static final String TAG = CV03AceptarOperacion.class.getSimpleName();

    private EditText oEditTextNumberAccount, oEditTextMoneyAccount, oEditTextAmountTransfer, oEditTextBeneficiary;
    private EditText oEditTextNumberAccountBeneficiary, oEditTextReferenceOrdenant, oEditTextReferenceBeneficiary;
    private EditText oEditTextTypeRaces, oEditTextAmountFee, oEditTextAmountEquivalent;

    private CEAcceptation oCEAcceptation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity03_aceptar_operarion);

        oEditTextNumberAccount = findViewById(R.id.id_et_numero_cuenta_origen);
        oEditTextMoneyAccount = findViewById(R.id.id_et_moneda_a_transferir);
        oEditTextAmountTransfer = findViewById(R.id.id_et_importe_transferir);
        oEditTextBeneficiary = findViewById(R.id.id_et_nombre_beneficiario);
        oEditTextNumberAccountBeneficiary = findViewById(R.id.id_et_numero_cuenta_beneficiario);
        oEditTextReferenceOrdenant = findViewById(R.id.id_et_referencia_ordenante);
        oEditTextReferenceBeneficiary = findViewById(R.id.id_et_target_reference_transfer);

        oEditTextTypeRaces = findViewById(R.id.id_et_type_rates);
        oEditTextAmountFee = findViewById(R.id.id_et_amount_comision);
        oEditTextAmountEquivalent = findViewById(R.id.id_et_amount_equivalent);

        enabledEditText();
        oCEAcceptation = new CEAcceptation();
        loadDataSimulation();
        viewDataSimulation();

    }

    private void enabledEditText(){
        oEditTextNumberAccount.setEnabled(false);
        oEditTextMoneyAccount.setEnabled(false);
        oEditTextAmountTransfer.setEnabled(false);
        oEditTextBeneficiary.setEnabled(false);
        oEditTextNumberAccountBeneficiary.setEnabled(false);
        oEditTextReferenceOrdenant.setEnabled(false);
//        oEditTextReferenceBeneficiary.setEnabled(false);

        oEditTextTypeRaces.setEnabled(false);
        oEditTextAmountFee.setEnabled(false);
        oEditTextAmountEquivalent.setEnabled(false);
    }

    private void loadDataSimulation(){

        oCEAcceptation.setIdTransfer(152027L);
        oCEAcceptation.setNameOrigin("Hackathon Ninja Project");
        oCEAcceptation.setNumberAccountOrigin("0011-0121-30000123-123-1");
        oCEAcceptation.setMoneyAccountOrigin("USD");
        oCEAcceptation.setAmountOrigin(10.00);
        oCEAcceptation.setDateCurrent("2019-10-26");
        oCEAcceptation.setNameBeneficiary("Shaolin Identity One");
        oCEAcceptation.setNumberAccountBeneficiary("4545943403-959506-095-04-5");
        oCEAcceptation.setReferenceOrigin("Simulación de Transferencia ....!");

        oCEAcceptation.setTypeRates(4.522309);
        oCEAcceptation.setAmountFee(3.45);
        oCEAcceptation.setAmountEquivalent(60.83);
    }

    private void viewDataSimulation(){
        oEditTextNumberAccount.setText(oCEAcceptation.getNameOrigin());
        oEditTextMoneyAccount.setText(oCEAcceptation.getMoneyAccountOrigin());
        oEditTextAmountTransfer.setText(String.valueOf(oCEAcceptation.getAmountOrigin()));
        oEditTextBeneficiary.setText(oCEAcceptation.getNameBeneficiary());
        oEditTextNumberAccountBeneficiary.setText(oCEAcceptation.getNumberAccountBeneficiary());
        oEditTextReferenceOrdenant.setText(oCEAcceptation.getReferenceOrigin());

        oEditTextTypeRaces.setText(String.valueOf(oCEAcceptation.getTypeRates()));
        oEditTextAmountFee.setText(String.valueOf(oCEAcceptation.getAmountFee()));
        oEditTextAmountEquivalent.setText(String.valueOf(oCEAcceptation.getAmountEquivalent()));
    }
}
