package pe.bbva.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import pe.bbva.evalua.android4.entidad.CEMovimient;
import pe.bbva.evalua.android4.service.CSHttpHandler;

public class CV06ConsultLastMovimient extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = CV06ConsultLastMovimient.class.getSimpleName();

    private ListView oListLastMovimients;
    private ArrayList<HashMap<String, String>> oArrayListLastMovimient;
    private CEMovimient oCEMovimient;
    private List<CEMovimient> oListCEMovimient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity06_consult_last_movimient);

        oArrayListLastMovimient = new ArrayList<>();
        oListLastMovimients = findViewById(R.id.id_list_last_movimient);

        new getListMovimients().execute();

        oListLastMovimients.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(CV06ConsultLastMovimient.this, " Position : " + i + "Long = "+ l, Toast.LENGTH_LONG).show();

        CEMovimient oItemMovimient = oListCEMovimient.get(i);

        Intent oIntento = new Intent(this, CV0602ViewLastMovimient.class);

        oIntento.putExtra("vBeneficiary",oItemMovimient.getBeneficiary());
        oIntento.putExtra("vNumberAccountBeneficiary",oItemMovimient.getNumberAccountBeneficiary());
        oIntento.putExtra("vTypeRace", oItemMovimient.getTypeRace());
        oIntento.putExtra("vAmountComision", oItemMovimient.getAmountComision());
        oIntento.putExtra("vAmountTransfer", oItemMovimient.getAmountTransfer());
        oIntento.putExtra("vReferenceBeneficiary", oItemMovimient.getReferenceBeneficiary());

        startActivity(oIntento);
    }

    private class getListMovimients extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute(){
            String lsMensaje = "Json Data is downloading .....!";
            super.onPreExecute();
            Toast.makeText(CV06ConsultLastMovimient.this, lsMensaje, Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            CSHttpHandler oCSHttpHandler = new CSHttpHandler();
            String lsUrl = "http://ec2-18-224-40-63.us-east-2.compute.amazonaws.com:9090/bbva02/interpay/payments/";
            String lsJson = oCSHttpHandler.makeServiceCall(lsUrl);
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

                    JSONArray oJsonMovimient = new JSONArray(lsJson);
                    oListCEMovimient = new ArrayList<>();
                    // looping through All Operation
                    for(int i=0; i<oJsonMovimient.length();i++){
                        JSONObject c = oJsonMovimient.getJSONObject(i);
                        oCEMovimient = new CEMovimient();
                        oCEMovimient.setIdTransfer(c.getString("idTransfer"));
                        oCEMovimient.setDateMovimient(c.getString("dateMovimient"));
                        oCEMovimient.setStateMovimient(c.getString("stateMovimient"));
                        oCEMovimient.setAmountEquivalent(BigDecimal.valueOf(c.getDouble("amountEquivalent")));
                        oCEMovimient.setBeneficiary(c.getString("beneficiary"));
                        oCEMovimient.setNumberAccountBeneficiary(c.getString("numberAccountBeneficiary"));
                        oCEMovimient.setReferenceBeneficiary(String.valueOf(c.getString("referenceBeneficiary")));
                        oCEMovimient.setCurrencyBeneficiary(c.getString("currencyBeneficiary"));
                        oCEMovimient.setTypeRace(BigDecimal.valueOf(c.getDouble("rate")));
                        oCEMovimient.setAmountComision(BigDecimal.valueOf(c.getDouble("amountComision")));
                        oCEMovimient.setAmountTransfer(BigDecimal.valueOf(c.getDouble("amountTransfer")));
                        oCEMovimient.setCurrencyCode(c.getString("currencyCode"));


                        // tmp hash map for single contact
                        HashMap<String, String> oMapContact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        oMapContact.put("idTransferencia", oCEMovimient.getIdTransfer());
                        oMapContact.put("dateMovimient", oCEMovimient.getDateMovimient());
                        oMapContact.put("state", oCEMovimient.getStateMovimient());
                        oMapContact.put("money", oCEMovimient.getCurrencyBeneficiary());
                        oMapContact.put("amountTransfer", String.valueOf(oCEMovimient.getAmountEquivalent()));


                        // adding contact to contact list
                        oListCEMovimient.add(oCEMovimient);
                        oArrayListLastMovimient.add(oMapContact);
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
            ListAdapter oListAdapter = new SimpleAdapter(CV06ConsultLastMovimient.this, oArrayListLastMovimient, R.layout.activity0601_details_last_movimient, new String[]{"dateMovimient","state", "money", "amountTransfer"}, new int[]{R.id.id_text_date_movimient, R.id.id_text_state_movimient, R.id.id_text_money_movimient, R.id.id_text_amount_movimient});

            oListLastMovimients.setAdapter(oListAdapter);
        }
    }

}
