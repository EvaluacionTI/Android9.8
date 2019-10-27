package pe.inverfin.evalua.android4.service;
//https://des.wallet.bbvacontinental.pe/QSRV_A02/TechArchitecture/pe/grantingTicket/V02/?_wadl
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CSHttpHandler {
    private static final String TAG = CSHttpHandler.class.getSimpleName();
    private URL oUrl;
    private HttpsURLConnection oHttpUrlCxn = null;
    private CSCustomSSLSocketFactory oSSLSocketFactory = null;

    public CSHttpHandler() {
    }

    public String makeServiceCall(String psRequestUrl, Context poContext) {
        String lsResponse = null;

        Log.i(TAG, "call URL" + psRequestUrl);
        try {
            oUrl = new URL(psRequestUrl);
            Log.i(TAG, "URL : {}" + oUrl);
            oHttpUrlCxn = (HttpsURLConnection) oUrl.openConnection();
            Log.i(TAG, "HttpURLConnection : {}" + oHttpUrlCxn);


            // Add request Header
            oHttpUrlCxn.setRequestMethod("POST");
            oHttpUrlCxn.setRequestProperty("Content-Type", "application/json");
            oHttpUrlCxn.setRequestProperty("Accept", "application/json");
            oHttpUrlCxn.setConnectTimeout(20000);
            oHttpUrlCxn.setDoInput(true);
            oHttpUrlCxn.setDoOutput(true);
            //oHttpUrlCxn.setSSLSocketFactory(oSSLSocketFactory.getSSLSocketFactory(poContext));
            oHttpUrlCxn.connect();

            Log.i(TAG, "add Header : {}" + oHttpUrlCxn);

            //Add Post Data in JSON
            JSONObject oJsonData = new JSONObject();

            JSONObject oJsonAuthentication = new JSONObject();
            oJsonAuthentication.put("userID", "L38140100");
            oJsonAuthentication.put("consumerID", "13999901");
            oJsonAuthentication.put("authenticationType", "02");

            JSONArray oJsonArrayNivel0 = new JSONArray();

            JSONObject oJsonPassword = new JSONObject();
            oJsonPassword.put("idAuthenticationData", "password");
            JSONArray oJsonArrayNivel1 = new JSONArray();
            oJsonArrayNivel1.put("wallet01");
            oJsonPassword.put("authenticationData", oJsonArrayNivel1);
            oJsonArrayNivel0.put(oJsonPassword);

            oJsonAuthentication.put("authenticationData", oJsonArrayNivel0);
            oJsonData.put("authentication", oJsonAuthentication);

            JSONObject oJsonBackendUserRequest = new JSONObject();
            oJsonBackendUserRequest.put("userId", "");
            oJsonBackendUserRequest.put("accessCode", "");
            oJsonBackendUserRequest.put("dialogId", "");

            oJsonData.put("backendUserRequest", oJsonBackendUserRequest);

            //Create a writer object and make the request
            OutputStream oOStream = oHttpUrlCxn.getOutputStream();
            OutputStreamWriter oOStremWriter = new OutputStreamWriter(oOStream);
            BufferedWriter oBWriter = new BufferedWriter(oOStremWriter);
            oBWriter.write(oJsonData.toString());
            oBWriter.flush();
            oBWriter.close();

            //Get the Response code for the request

            int liResponseCode = oHttpUrlCxn.getResponseCode();
            Log.i(TAG, "getResponseCode : {}" + liResponseCode);

            if (liResponseCode==HttpURLConnection.HTTP_OK){
                InputStream oIstream = new BufferedInputStream(oHttpUrlCxn.getInputStream());
                convertStreamToString(oIstream);
            }
        } catch (MalformedURLException ex) {
            Log.e(TAG, "MalformedURLException : " + ex.getMessage());
        } catch (ProtocolException ex) {
            Log.e(TAG, "ProtocolException : " + ex.getMessage());
        } catch (IOException ex) {
            Log.e(TAG, "IOException : " + ex.getMessage());
        } catch (Exception ex) {
            Log.e(TAG, "Exception : " + ex.getMessage());
        }finally {
            oHttpUrlCxn.disconnect();
        }
        return lsResponse;
    }
//15:47:41.381 27388-27442/pe.inverfin.evalua.android4.view E/CSHttpHandler: IOException : java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.
    public String convertStreamToString(InputStream poIstream) {
        InputStreamReader oIStreamReader = new InputStreamReader(poIstream);
        BufferedReader oBReader = new BufferedReader(oIStreamReader);
        StringBuilder oSBuilder = new StringBuilder();
        String lsRow;

        try {
            while ((lsRow = oBReader.readLine()) != null) {
                oSBuilder.append(lsRow).append("\n");
            }

        } catch (IOException ex) {
            Log.e(TAG, "IOException : " + ex.getMessage());
        } finally {
            try {
                poIstream.close();
            } catch (IOException ex) {
                Log.e(TAG, "IOException : " + ex.getMessage());
            }
        }
        return oSBuilder.toString();
    }
}
