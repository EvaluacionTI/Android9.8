package pe.inverfin.evalua.android4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import pe.inverfin.evalua.android4.entity.CECustomer;
import pe.inverfin.evalua.android4.service.ServiceTask;

public class MainActivity extends AppCompatActivity {
    private EditText oEtIdentificador, oEtFirstName, oEtLastName, oEtEmail, oEtCelular, oEtDateBirth;
    private Button oBtnEnviar;
    private CECustomer oCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        oEtIdentificador = findViewById(R.id.id_editText_identificador);
        oEtFirstName = findViewById(R.id.id_editText_first_name);
        oEtLastName = findViewById(R.id.id_editText_last_name);
        oEtEmail = findViewById(R.id.id_editText_email);
        oEtCelular = findViewById(R.id.id_editText_celular);
        oEtDateBirth = findViewById(R.id.id_editText_date_birth);

        oBtnEnviar = findViewById(R.id.id_btn_enviar);

        oCliente = new CECustomer();
        consumoServicioGet();

        oBtnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consumoServicioPost();
            }
        });

    }

    /*
    Es necesario importar las librerias de http

     */
    public void consumoServicioPost(){
        // Ejecutar el hilo creado
        String lUri = "http://localhost:8020/customers/";
        ServiceTask oCSServiceRest = new ServiceTask(getApplicationContext(), lUri);
        oCSServiceRest.execute();

    }

    public void consumoServicioGet(){
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

    }
}
