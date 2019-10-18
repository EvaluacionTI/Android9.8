package pe.bbva.evalua.android4.service;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CSHttpHandler {
    private static final String TAG = CSHttpHandler.class.getSimpleName();

    public CSHttpHandler(){}

    public String makeServiceCall(String psRequestUrl){
        String lsResponse = null;
/*
POST https://des.wallet.bbvacontinental.pe/QSRV_A02/TechArchitecture/pe/grantingTicket/V02

PAYLOAD:
{
  "authentication": {
      "userID": "L38140100",
      "consumerID": "13999901",
      "authenticationType": "02",
      "authenticationData": [
          {
              "idAuthenticationData": "password",
              "authenticationData": [
                  "wallet01"
              ]
          }
      ]
  },
  "backendUserRequest": {
      "userId":"",
      "accessCode": "",
      "dialogId": ""
  }
}

respuesta: cabecera "tsec"
 */
        try{
            URL oUrl = new URL(psRequestUrl);
            HttpURLConnection oHttpUrlCxn = (HttpURLConnection) oUrl.openConnection();
            oHttpUrlCxn.setRequestMethod("POST");
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
}
