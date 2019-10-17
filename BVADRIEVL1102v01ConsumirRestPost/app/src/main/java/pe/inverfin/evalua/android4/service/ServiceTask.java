package pe.inverfin.evalua.android4.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

public class ServiceTask extends AsyncTask<Void, Void, Void> {
    //1. Variables del hilo
    public String resultadoapi="";
    public String linkrequestAPI=""; //Link para consumir el servicio rest

    private Context httpContext;
    private ProgressDialog progressDialog;

    //2. Constructor

    public ServiceTask(Context poContext, String psLinkApi){
        this.httpContext = poContext;
        this.linkrequestAPI = psLinkApi;
    }

    //3. Preprocesor
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        //progressDialog = ProgressDialog.show(httpContext, "Process request", "A moment please");
        Toast.makeText(this.httpContext, "Json Data is downloading .....!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {



        String result = null;

        String wsURL = linkrequestAPI;
        URL url = null;
        try{
            // Se crea la conexion al api
            url=new URL(wsURL);
            HttpURLConnection oUrlConnection = (HttpURLConnection) url.openConnection();

            // Crear el objecto json para enviar un post
            JSONObject oDataPost = new JSONObject();

            oDataPost.put("id", 5);
            oDataPost.put("firstName", 5);
            oDataPost.put("lastName", 5);
            oDataPost.put("email", 5);
            oDataPost.put("mobile", 5);
            oDataPost.put("dateOfBirth", 5);

            //Definir parametros de conexion
            oUrlConnection.setReadTimeout(15000); //Milisegundos
            oUrlConnection.setConnectTimeout(10000); //Milisegundos
            oUrlConnection.setRequestMethod("POST"); //se puede cambiar por delete, put, etc
            oUrlConnection.setDoInput(true);
            oUrlConnection.setDoOutput(true);

            //Obtener el resultado request
            OutputStream oOs = oUrlConnection.getOutputStream();
            OutputStreamWriter oOsw = new OutputStreamWriter(oOs, "UTF-8");
            BufferedWriter oBw = new BufferedWriter(oOsw);
            oBw.write(convertJsonToString(oDataPost));
            oBw.flush();
            oBw.close();
            oOs.close();

            int responseCode = oUrlConnection.getResponseCode(); //Conexion OK
            if (responseCode==HttpURLConnection.HTTP_OK){
                InputStreamReader oIsr = new InputStreamReader(oUrlConnection.getInputStream());
                BufferedReader oBr = new BufferedReader(oIsr);
                StringBuffer oSBuffer = new StringBuffer("");
                String linea="";
                while((linea=oBr.readLine())!=null){
                    oSBuffer.append(linea);
                    break;
                }
                oBr.close();
                result=oSBuffer.toString();
            }else{
                result=new String("Error = " + responseCode);
            }

        }catch (MalformedURLException ex){
            ex.getMessage();
        }catch (IOException ex){
            ex.getMessage();
        }catch(JSONException ex){
            ex.getMessage();
        }

        return null;
    }

    //4. Postprocesor
    // Mostrará una notificación ccn el resultado del request
    protected void onPostExecute(){
        //protected void onPostExecute(String ps){
        //super.onPostExecute(ps);
        progressDialog.dismiss();
        //resultadoapi=ps;
        Toast.makeText(httpContext,resultadoapi,Toast.LENGTH_LONG).show();
    }

    public String convertJsonToString(JSONObject poJsonObject) throws UnsupportedEncodingException, JSONException {
        StringBuilder oSbResult = new StringBuilder();
        boolean lbFirst = true;
        Iterator<String> oIterable = poJsonObject.keys();

        while(oIterable.hasNext()){
            String sKey = oIterable.next();
            Object oValue = poJsonObject.get(sKey);

            if (lbFirst){
                lbFirst=false;
            }else{
                oSbResult.append("&");
            }
            oSbResult.append(URLEncoder.encode(sKey,"UTF-8"));
            oSbResult.append("=");
            oSbResult.append(URLEncoder.encode(oValue.toString(),"UTF-8"));
        }
        return oSbResult.toString();
    }

}
