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
    private List<CEMovimient> oCEMovimient;

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
        Intent oIntento = new Intent(this, CV0602ViewLastMovimient.class);

        oIntento.putExtra("vBeneficiary","Ninja Project ");
        oIntento.putExtra("vNumberAccountBeneficiary","242526-28");
        oIntento.putExtra("vTypeRace", "3.4667");
        oIntento.putExtra("vAmountComision", "5.00");
        oIntento.putExtra("vAmountTransfer", "100.09");
        oIntento.putExtra("vReferenceBeneficiary", "Ninja España");

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
            String lsUrl = "https://api.androidhive.info/contacts/";
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
                    JSONObject oJsonObject = new JSONObject(lsJson);
                    //getting JSON Array node
                    // "contacts" es el nombre del objeto JSON del API
                    JSONArray oJsonContacts = oJsonObject.getJSONArray("contacts");

                    // looping through All Contacts
                    for(int i=0; i<oJsonContacts.length();i++){
                        JSONObject c = oJsonContacts.getJSONObject(i);
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
            ListAdapter oListAdapter = new SimpleAdapter(CV06ConsultLastMovimient.this, oArrayListLastMovimient, R.layout.activity0601_details_last_movimient, new String[]{"fecha","estado", "moneda", "movimiento"}, new int[]{R.id.id_text_date_movimient, R.id.id_text_state_movimient, R.id.id_text_money_movimient, R.id.id_text_amount_movimient});

            oListLastMovimients.setAdapter(oListAdapter);
        }
    }



}
