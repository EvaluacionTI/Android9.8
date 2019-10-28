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

import pe.bbva.evalua.android4.entidad.CEMovimient;
import pe.bbva.evalua.android4.entidad.CESimulation;
import pe.bbva.evalua.android4.service.CSHttpHandler;

public class CV02SimularOperacion extends AppCompatActivity {
    private static final String TAG = CV02SimularOperacion.class.getSimpleName();

    private EditText oEditTextNumberAccount, oEditTextMoneyAccount, oEditTextAmountTransfer, oEditTextBeneficiary;
    private EditText oEditTextNumberAccountBeneficiary, oEditTextReferenceOrdenant;
    private Button oButtonSimular;
    private CESimulation oCESimulation;


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
        oCESimulation.setNumberAccountOrigin("0011-0121-30000123-123-1");
        oCESimulation.setMoneyAccountOrigin("USD");
        oCESimulation.setAmountOrigin(10.00);
        oCESimulation.setDateCurrent("2019-10-26");
        oCESimulation.setNameBeneficiary("Shaolin Identity One");
        oCESimulation.setNumberAccountBeneficiary("4545943403-959506-095-04-5");
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
                    //getting JSON Array node
                    // "contacts" es el nombre del objeto JSON del API
                    JSONArray oJsonData = oJsonObject.getJSONArray("contacts");

                    // looping through All Contacts
                    oCESimulation = new CESimulation();

                    for(int i=0; i<oJsonData.length();i++){
                        JSONObject c = oJsonData.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        // Phone node is JSON Object
                        JSONObject oJsonPhone = c.getJSONObject("phone");
                        String mobile = oJsonPhone.getString("mobile");
                        String home = oJsonPhone.getString("home");
                        String office = oJsonPhone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> oMapContact = new HashMap<>();

                        // Determinar si numero es par o impar
                        if (i%2==0){
                            name = "25/10/2019";
                            email = "ACCEPT";
                            address = "USD";
                            mobile = "5,898.93";
                        }else{
                            name = "26/10/2019";
                            email = "CONFORM";
                            address = "EUR";
                            mobile = "99,983,939.99";
                        }
                        // adding each child node to HashMap key => value
                        oMapContact.put("id", id);
                        oMapContact.put("fecha", name);
                        oMapContact.put("estado", email);
                        oMapContact.put("moneda", address);
                        oMapContact.put("movimiento", mobile);


                        // adding contact to contact list
                     //   oArrayListLastMovimient.add(oMapContact);
                    }

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
           // ListAdapter oListAdapter = new SimpleAdapter(CV02SimularOperacion.this, oArrayListLastMovimient, R.layout.activity0601_details_last_movimient, new String[]{"fecha","estado", "moneda", "movimiento"}, new int[]{R.id.id_text_date_movimient, R.id.id_text_state_movimient, R.id.id_text_money_movimient, R.id.id_text_amount_movimient});

            //oListLastMovimients.setAdapter(oListAdapter);
        }
    }
}
