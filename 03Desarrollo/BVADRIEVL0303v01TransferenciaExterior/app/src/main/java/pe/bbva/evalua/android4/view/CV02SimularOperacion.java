package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import pe.bbva.evalua.android4.entidad.CEAcceptation;
import pe.bbva.evalua.android4.entidad.CEMovimient;
import pe.bbva.evalua.android4.entidad.CESimulation;
import pe.bbva.evalua.android4.service.CSHttpHandler;

public class CV02SimularOperacion extends AppCompatActivity {
    private static final String TAG = CV02SimularOperacion.class.getSimpleName();

    private EditText oEditTextNumberAccount, oEditTextMoneyAccount, oEditTextAmountTransfer, oEditTextBeneficiary;
    private EditText oEditTextNumberAccountBeneficiary, oEditTextReferenceOrdenant;
    private Button oButtonSimular;
    private CESimulation oCESimulation;
    private CEAcceptation oCEAcceptation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_simular_operacion);

        oEditTextNumberAccount = findViewById(R.id.id_et_numero_cuenta_origen);
        oEditTextMoneyAccount = findViewById(R.id.id_et_moneda_a_transferir);
        oEditTextAmountTransfer = findViewById(R.id.id_et_importe_transferir);
        oEditTextBeneficiary = findViewById(R.id.id_et_nombre_beneficiario);
        oEditTextNumberAccountBeneficiary = findViewById(R.id.id_et_numero_cuenta_beneficiario);
        oEditTextReferenceOrdenant = findViewById(R.id.id_et_referencia_ordenante);

        enabledEditText();
        oCESimulation = new CESimulation();

        loadDataSimulation();
        viewDataSimulation();
        oButtonSimular = findViewById(R.id.id_btn_simular_transferencia);

        oButtonSimular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new postSimulation().execute();
            }
        });

    }

    private void enabledEditText(){
        oEditTextNumberAccount.setEnabled(false);
        oEditTextMoneyAccount.setEnabled(false);
        oEditTextAmountTransfer.setEnabled(false);
        oEditTextBeneficiary.setEnabled(false);
        oEditTextNumberAccountBeneficiary.setEnabled(false);
        oEditTextReferenceOrdenant.setEnabled(false);
    }

    private void loadDataSimulation(){
        oCESimulation = new CESimulation();

        oCESimulation.setIdTransfer(152027L);
        oCESimulation.setNameOrigin("Hackathon Ninja Project");
        oCESimulation.setNumberAccountOrigin("00110121300001231231");
        oCESimulation.setMoneyAccountOrigin("PEN");
        oCESimulation.setAmountOrigin(11.20);
        oCESimulation.setDateCurrent("2019-10-26");
        oCESimulation.setNameBeneficiary("Shaolin Identity One");
        oCESimulation.setNumberAccountBeneficiary("00110121300009900990923");
        oCESimulation.setMoneyAccountBeneficiary("USD");
        oCESimulation.setReferenceOrigin("Simulación de Transferencia ....!");

    }

    private void viewDataSimulation(){
        oEditTextNumberAccount.setText(oCESimulation.getNameOrigin());
        oEditTextMoneyAccount.setText(oCESimulation.getMoneyAccountOrigin());
        oEditTextAmountTransfer.setText(String.valueOf(oCESimulation.getAmountOrigin()));
        oEditTextBeneficiary.setText(oCESimulation.getNameBeneficiary());
        oEditTextNumberAccountBeneficiary.setText(oCESimulation.getNumberAccountBeneficiary());
        oEditTextReferenceOrdenant.setText(oCESimulation.getReferenceOrigin());
    }

    private class postSimulation extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute(){
            String lsMensaje = "Json Data is downloading .....!";
            super.onPreExecute();
            Toast.makeText(CV02SimularOperacion.this, lsMensaje, Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            CSHttpHandler oCSHttpHandler = new CSHttpHandler();
            String lsUrl = "http://ec2-18-224-40-63.us-east-2.compute.amazonaws.com:9090/bbva/payment-cross/simulate";
            String lsJson = oCSHttpHandler.callSimulateTransfer(lsUrl, oCESimulation);
            Log.i(TAG, "Response from URL" + lsJson);
            if (lsJson==null){
                Log.e(TAG, "Couldn't get json from server");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                    }
                });
            }else{
                try{
                    JSONObject oJsonObject = new JSONObject(lsJson);

                    oCEAcceptation = new CEAcceptation();

                    oCEAcceptation.setIdTransfer(oJsonObject.getLong("idTransfer"));
                    oCEAcceptation.setTypeRates(oJsonObject.getDouble("typeRates"));
                    oCEAcceptation.setAmountFee(oJsonObject.getDouble("amountFee"));
                    oCEAcceptation.setAmountEquivalent(oJsonObject.getDouble("amountEquivalent"));
                    oCEAcceptation.setReferenceBeneficiary(oJsonObject.getString("idQuoteExternal"));

                }catch (JSONException ex) {
                    Log.e(TAG, "Json parsing error:" + ex.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Json parsing error:", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
            return null;
        }


        @Override
        protected  void onPostExecute(Void poResult){
            super.onPostExecute(poResult);
            String lsMensaje = oCEAcceptation.getAmountFee() + "/" + oCEAcceptation.getReferenceBeneficiary();
            Toast.makeText(getApplicationContext(), "Ref.: " + lsMensaje, Toast.LENGTH_LONG).show();
           // ListAdapter oListAdapter = new SimpleAdapter(CV02SimularOperacion.this, oArrayListLastMovimient, R.layout.activity0601_details_last_movimient, new String[]{"fecha","estado", "moneda", "movimiento"}, new int[]{R.id.id_text_date_movimient, R.id.id_text_state_movimient, R.id.id_text_money_movimient, R.id.id_text_amount_movimient});

            //oListLastMovimients.setAdapter(oListAdapter);
        }
    }
}
