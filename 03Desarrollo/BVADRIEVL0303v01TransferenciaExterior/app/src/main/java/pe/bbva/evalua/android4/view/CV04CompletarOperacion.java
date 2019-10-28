package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

import pe.bbva.evalua.android4.entidad.CEAcceptation;
import pe.bbva.evalua.android4.entidad.CEConfirm;

public class CV04CompletarOperacion extends AppCompatActivity {
    private static final String TAG = CV04CompletarOperacion.class.getSimpleName();

    private EditText oEditTextNumberAccount, oEditTextMoneyAccount, oEditTextAmountTransfer, oEditTextBeneficiary;
    private EditText oEditTextNumberAccountBeneficiary, oEditTextReferenceOrdenant, oEditTextReferenceBeneficiary;
    private EditText oEditTextTypeRaces, oEditTextAmountFee, oEditTextAmountEquivalent;
    private EditText oEditTextStateTransferBeneficiary, oEditTextIdTransferBeneficiary;

    private CEConfirm oCEConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity04_completar_operacion);

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

        oEditTextStateTransferBeneficiary = findViewById(R.id.id_et_state_transfer);
        oEditTextIdTransferBeneficiary = findViewById(R.id.id_et_target_reference_transfer);

        enabledEditText();
        oCEConfirm = new CEConfirm();
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
        oEditTextReferenceBeneficiary.setEnabled(false);

        oEditTextTypeRaces.setEnabled(false);
        oEditTextAmountFee.setEnabled(false);
        oEditTextAmountEquivalent.setEnabled(false);

        oEditTextStateTransferBeneficiary.setEnabled(false);
        oEditTextIdTransferBeneficiary.setEnabled(false);
    }

    private void loadDataSimulation(){

        oCEConfirm.setIdTransfer(152027L);
        oCEConfirm.setNameOrigin("Hackathon Ninja Project");
        oCEConfirm.setNumberAccountOrigin("0011-0121-30000123-123-1");
        oCEConfirm.setMoneyAccountOrigin("USD");
        oCEConfirm.setAmountOrigin(10.00);
        oCEConfirm.setDateCurrent("2019-10-26");
        oCEConfirm.setNameBeneficiary("Shaolin Identity One");
        oCEConfirm.setNumberAccountBeneficiary("4545943403-959506-095-04-5");
        oCEConfirm.setReferenceOrigin("Simulación de Transferencia ....!");

        oCEConfirm.setTypeRates(4.522309);
        oCEConfirm.setAmountFee(3.45);
        oCEConfirm.setAmountEquivalent(60.83);

        oCEConfirm.setStateTransfer("ACCEPT");
        oCEConfirm.setIdTransferBeneficiary(String.valueOf(UUID.randomUUID()));
    }

    private void viewDataSimulation(){
        oEditTextNumberAccount.setText(oCEConfirm.getNameOrigin());
        oEditTextMoneyAccount.setText(oCEConfirm.getMoneyAccountOrigin());
        oEditTextAmountTransfer.setText(String.valueOf(oCEConfirm.getAmountOrigin()));
        oEditTextBeneficiary.setText(oCEConfirm.getNameBeneficiary());
        oEditTextNumberAccountBeneficiary.setText(oCEConfirm.getNumberAccountBeneficiary());
        oEditTextReferenceOrdenant.setText(oCEConfirm.getReferenceOrigin());

        oEditTextTypeRaces.setText(String.valueOf(oCEConfirm.getTypeRates()));
        oEditTextAmountFee.setText(String.valueOf(oCEConfirm.getAmountFee()));
        oEditTextAmountEquivalent.setText(String.valueOf(oCEConfirm.getAmountEquivalent()));

        oEditTextStateTransferBeneficiary.setText(oCEConfirm.getStateTransfer());
        oEditTextIdTransferBeneficiary.setText(oCEConfirm.getIdTransferBeneficiary());
    }
}
