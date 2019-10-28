package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;
import java.util.UUID;

import pe.bbva.evalua.android4.entidad.CETransfer;

public class CV05ConsultaTargetTransfer extends AppCompatActivity {
    private static final String TAG = CV05ConsultaTargetTransfer.class.getSimpleName();

    private EditText oEditTextTargetNumberTransfer;
    private EditText oEditTextTargetDateTransfer;
    private EditText oEditTextTargetHourTransfer;
    private EditText oEditTextTargetMoneyTransfer;
    private EditText oEditTextTargetAmountTransfer;
    private EditText oEditTextTargetReferenceTransfer;
    private CETransfer oCETransferTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity05_consulta_transfer);

        oEditTextTargetNumberTransfer = findViewById(R.id.id_et_target_number_transfer);
        oEditTextTargetDateTransfer = findViewById(R.id.id_et_target_date_transfer);
        oEditTextTargetHourTransfer = findViewById(R.id.id_et_target_hour_transfer);
        oEditTextTargetMoneyTransfer = findViewById(R.id.id_et_target_money_transfer);
        oEditTextTargetAmountTransfer = findViewById(R.id.id_et_target_amount_transfer);
        oEditTextTargetReferenceTransfer = findViewById(R.id.id_et_target_reference_transfer);

        //Inhabilitando entrada de datos
        oEditTextTargetNumberTransfer.setEnabled(false);
        oEditTextTargetDateTransfer.setEnabled(false);
        oEditTextTargetHourTransfer.setEnabled(false);
        oEditTextTargetMoneyTransfer.setEnabled(false);
        oEditTextTargetAmountTransfer.setEnabled(false);
        oEditTextTargetReferenceTransfer.setEnabled(false);

        //Load data of transfer
        oCETransferTarget = new CETransfer();
        loadTransfer();

        oEditTextTargetNumberTransfer.setText(oCETransferTarget.getTargetNumberTransfer());
        oEditTextTargetDateTransfer.setText(oCETransferTarget.getTargetDateTransfer());
        oEditTextTargetHourTransfer.setText(oCETransferTarget.getTargetHourTransfer());
        oEditTextTargetMoneyTransfer.setText(oCETransferTarget.getTargetMoneyTransfer());
        oEditTextTargetAmountTransfer.setText(oCETransferTarget.getTargetAmountTransfer());
        oEditTextTargetReferenceTransfer.setText(oCETransferTarget.getTargetReferenceTransfer());

    }

    private void loadTransfer(){


        oCETransferTarget.setTargetNumberTransfer(String.valueOf(UUID.randomUUID()));
        oCETransferTarget.setTargetDateTransfer("27/10/2019");
        oCETransferTarget.setTargetHourTransfer("18:49:05");
        oCETransferTarget.setTargetMoneyTransfer("USD");
        oCETransferTarget.setTargetAmountTransfer("10.00");
        oCETransferTarget.setTargetReferenceTransfer("549-384-*****-939-09, PE-LIMA");
    }

}
