package pe.inverfin.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

import pe.inverfin.evalua.androi4.service.CSHttpHandler;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private ListView oLvCustomer;
    private List<CECustomer> oListCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        oLvCustomer = findViewById(R.id.id_lv_customer);

    }

    protected void readUriGet(){
        //0. Declarar class
        CSHttpHandler oHandler = new CSHttpHandler();

        //1. Declarar la url a invocar
        String lsUrl = "http://localhost:8020/customers";

        //2. Lectura del rest
        String lsJson = oHandler.makeServiceCallRest(lsUrl);
        Log.e(TAG, "Response from url: " + lsJson);

        if (lsJson!=null){

        }else{
            Log.e(TAG, "Couldn't get json from server : " + lsJson);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Couldn't get json from server", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    protected void readFromJson(String psJson){

        try{
            JSONObject oJObject = new JSONObject(psJson);
            Log.i(TAG, "JSONObject : " + oJObject);

            // Getting JSON Array node
            JSONArray oJArray = oJObject.getJSONArray("vListCustomer");

            // looping through All Customer
            for (int i =0 ; i <oJArray.length(); i++ ){
                JSONObject oJOCustomer =  oJArray.getJSONObject(i);

            }

        }catch (final JSONException ex){
            Log.e(TAG, "Json parsing error : " + ex.getMessage());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Json parsing error" + ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
