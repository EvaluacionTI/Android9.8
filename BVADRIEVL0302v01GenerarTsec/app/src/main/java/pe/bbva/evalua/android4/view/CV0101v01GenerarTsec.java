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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import pe.bbva.evalua.android4.service.CSHttpHandler;

public class CV0101v01GenerarTsec extends AppCompatActivity {
    private static final String TAG = CV0101v01GenerarTsec.class.getSimpleName();

    private TextView oTvNumeroTsec;
    private EditText oEtUsuario, oEtPassword;
    private Button oBtnGenerarTsec;
    private String sRptaTsec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oEtUsuario.findViewById(R.id.id_edit_text_usuario);
        oEtPassword.findViewById(R.id.id_edit_text_password);
        oTvNumeroTsec.findViewById(R.id.id_text_view_tsec);
        oBtnGenerarTsec.findViewById(R.id.id_button_generar_tsec);

        oEtUsuario.setText("L38140100");
        oEtPassword.setText("wallet01");

        oBtnGenerarTsec.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new getTsec().execute();
                oTvNumeroTsec.setText(sRptaTsec);
            }
        });
    }

    private class getTsec extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            String lsMensaje = "Json Data is downloading .....!";
            super.onPreExecute();
            Toast.makeText(CV0101v01GenerarTsec.this, lsMensaje, Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            CSHttpHandler oCSHttpHandler = new CSHttpHandler();
            String lsUrl = "https://des.wallet.bbvacontinental.pe/QSRV_A02/TechArchitecture/pe/grantingTicket/V02 ";
            String lsJson = oCSHttpHandler.makeServiceCall(lsUrl);
            Log.i(TAG, "Response from URL" + lsJson);
            if (lsJson == null) {
                Log.e(TAG, "Couldn't get json from server");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                try {
                    JSONObject oJsonObject = new JSONObject(lsJson);
                    //getting JSON Array node
                    // "contacts" es el nombre del objeto JSON del API


                } catch (JSONException ex) {
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
        protected void onPostExecute(Void poResult) {
            super.onPostExecute(poResult);

        }
    }

}