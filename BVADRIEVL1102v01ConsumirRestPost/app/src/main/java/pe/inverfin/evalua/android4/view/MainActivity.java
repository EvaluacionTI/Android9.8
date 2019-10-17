package pe.inverfin.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import pe.inverfin.evalua.android4.service.CSHttpHandler;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView oListViewContacts;
    private ArrayList<HashMap<String, String>> oArrayListContacts;
//    private EditText oEtIdentificador, oEtFirstName, oEtLastName, oEtEmail, oEtCelular, oEtDateBirth;
//    private Button oBtnEnviar;
//    private CECustomer oCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oArrayListContacts = new ArrayList<>();
        oListViewContacts = findViewById(R.id.id_list_view_contacts);

        new getListContacts().execute();

    }

    private class getListContacts extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute(){
            String lsMensaje = "Json Data is downloading .....!";
            super.onPreExecute();
            Toast.makeText(MainActivity.this, lsMensaje, Toast.LENGTH_LONG).show();
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

                        // adding each child node to HashMap key => value
                        oMapContact.put("id", id);
                        oMapContact.put("name", name);
                        oMapContact.put("email", email);
                        oMapContact.put("address", address);
                        oMapContact.put("mobile", mobile);

                        // adding contact to contact list
                        oArrayListContacts.add(oMapContact);
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
            ListAdapter oListAdapter = new SimpleAdapter(MainActivity.this, oArrayListContacts, R.layout.activity_view_contacts, new String[]{"email","mobile"}, new int[]{R.id.id_text_view_email, R.id.id_text_view_phone});

            oListViewContacts.setAdapter(oListAdapter);
        }
    }



    /*
    Es necesario importar las librerias de http

     */
 /*   public void consumoServicioPost(){
        // Ejecutar el hilo creado
        String lUri = "http://localhost:8020/customers/";
        ServiceTask oCSServiceRest = new ServiceTask(getApplicationContext(), lUri);
        oCSServiceRest.execute();

    }*/

 /*   public void consumoServicioGet(){
        String lsUri = "http://localhost:8020/customers";


        StrictMode.ThreadPolicy oPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(oPolicy);

        URL oUrl = null;
        HttpURLConnection oHttpUriConexion;

        try{
            oUrl = new URL(lsUri);
            oHttpUriConexion = (HttpURLConnection) oUrl.openConnection();
            oHttpUriConexion.setRequestMethod("GET");

            InputStreamReader oIsReader = new InputStreamReader(oHttpUriConexion.getInputStream());
            BufferedReader oBReader = new BufferedReader(oIsReader);

            String linea;
            StringBuffer response = new StringBuffer();
            String json = null;

            while((linea =oBReader.readLine())!=null){
                response.append(linea);
            }

            json = response.toString();
            JSONArray oJArray = null;
            oJArray = new JSONArray(json);

            for(int i=0;i<oJArray.length();i++){
                JSONObject oJObject = oJArray.getJSONObject(i);

                oCliente.setId(oJObject.getLong("id"));
                oCliente.setFirstName(oJObject.getString("firstName"));
                oCliente.setLastName(oJObject.getString("lastName"));
                oCliente.setEmail(oJObject.getString("email"));
                oCliente.setMobile(oJObject.getString("mobile"));
              //  oCliente.setDateOfBirth(oJObject.getJSONObject("dateOfBirth"));

                Log.d("CUSTOMER", oJObject.getString("firstName"));
            }


            oHttpUriConexion.connect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/
}
