package pe.bbva.evalua.android4.service;

import android.util.Log;

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

import pe.bbva.evalua.android4.entidad.CESimulation;

public class CSHttpHandler {
    private static final String TAG = CSHttpHandler.class.getSimpleName();

    public CSHttpHandler(){}

    public String makeServiceCall(String psRequestUrl){
        String lsResponse = null;

        try{
            URL oUrl = new URL(psRequestUrl);
            HttpURLConnection oHttpUrlCxn = (HttpURLConnection) oUrl.openConnection();
            oHttpUrlCxn.setRequestMethod("GET");
            // Read the response
            InputStream oIstream = new BufferedInputStream(oHttpUrlCxn.getInputStream());
            lsResponse = convertStreamToString(oIstream);
        }catch(MalformedURLException ex){
            Log.e(TAG, "MalformedURLException : " + ex.getMessage());
        }catch (ProtocolException ex){
            Log.e(TAG, "ProtocolException : " + ex.getMessage());
        }catch (IOException ex){
            Log.e(TAG, "IOException : " + ex.getMessage());
        }catch (Exception ex){
            Log.e(TAG, "Exception : " + ex.getMessage());
        }
        return lsResponse;
    }

    public String convertStreamToString(InputStream poIstream){
        InputStreamReader oIStreamReader = new InputStreamReader(poIstream);
        BufferedReader oBReader = new BufferedReader(oIStreamReader);
        StringBuilder oSBuilder = new StringBuilder();
        String lsRow;

        try{
            while ((lsRow=oBReader.readLine())!=null){
                oSBuilder.append(lsRow).append("\n");
            }

        }catch(IOException ex){
            Log.e(TAG, "IOException : " + ex.getMessage());
        }finally {
            try{
                poIstream.close();
            }catch (IOException ex){
                Log.e(TAG, "IOException : " + ex.getMessage());
            }
        }
        return oSBuilder.toString();
    }

    public String callSimulateTransfer(String psRequestUrl, CESimulation poCEMovimient){
        String lsResponse = null;

        try{
            URL oUrl = new URL(psRequestUrl);
            HttpURLConnection oHttpUrlCxn = (HttpURLConnection) oUrl.openConnection();

            Log.i(TAG, "URL : {}" + oUrl);
            Log.i(TAG, "HttpURLConnection : {}" + oHttpUrlCxn);

            // Add request Header
            oHttpUrlCxn.setRequestMethod("POST");
            oHttpUrlCxn.setRequestProperty("Content-Type", "application/json");
            oHttpUrlCxn.setRequestProperty("Accept", "application/json");
            //oHttpUrlCxn.setConnectTimeout(20000);
            oHttpUrlCxn.setDoInput(true);
            oHttpUrlCxn.setDoOutput(true);
            oHttpUrlCxn.connect();

            Log.i(TAG, "add Header : {}" + oHttpUrlCxn);

            //Add Post Data in JSON
            JSONObject oJsonData = new JSONObject();

            oJsonData.put("nameOrigin", poCEMovimient.getNameOrigin());
            oJsonData.put("numberAccountOrigin", poCEMovimient.getNumberAccountOrigin());
            oJsonData.put("moneyAccountOrigin", poCEMovimient.getMoneyAccountOrigin());
            oJsonData.put("nameOrigin", poCEMovimient.getNameOrigin());
            oJsonData.put("amountOrigin", poCEMovimient.getAmountOrigin());
            oJsonData.put("dateCurrent", poCEMovimient.getDateCurrent());
            oJsonData.put("referenceOrigin", poCEMovimient.getReferenceOrigin());
            oJsonData.put("nameBeneficiary", poCEMovimient.getNameBeneficiary());
            oJsonData.put("numberAccountBeneficiary", poCEMovimient.getNumberAccountBeneficiary());
            oJsonData.put("moneyAccountBeneficiary", poCEMovimient.getMoneyAccountBeneficiary());

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

        }catch(MalformedURLException ex){
            Log.e(TAG, "MalformedURLException : " + ex.getMessage());
        }catch (ProtocolException ex){
            Log.e(TAG, "ProtocolException : " + ex.getMessage());
        }catch (IOException ex){
            Log.e(TAG, "IOException : " + ex.getMessage());
        }catch (Exception ex){
            Log.e(TAG, "Exception : " + ex.getMessage());
        }
        return lsResponse;
    }
}
