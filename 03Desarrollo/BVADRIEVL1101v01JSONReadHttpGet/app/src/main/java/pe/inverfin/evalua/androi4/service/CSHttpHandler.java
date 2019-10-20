package pe.inverfin.evalua.androi4.service;

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

    public String makeServiceCallRest(String psUrl){
        String lsResponse=null;

        try{
            URL oUrl = new URL(psUrl);

            HttpURLConnection oCxnUrl = (HttpURLConnection) oUrl.openConnection();
            oCxnUrl.setRequestMethod("GET");

            if (oCxnUrl.getResponseCode()==200){
                InputStream oIs = new BufferedInputStream(oCxnUrl.getInputStream());

                Log.i(TAG, "URL : " + oUrl);
                Log.i(TAG, "HttpURLConnection : " + oCxnUrl);
                Log.i(TAG, "InputStream : " + oIs);

                lsResponse = convertStreamToString(oIs);
                Log.i(TAG, "InputStream : " + lsResponse);
            }else{

            }
            oCxnUrl.disconnect();
        }catch(MalformedURLException ex){
            Log.e(TAG, "MalformedURLException : " + ex.getMessage());
        }catch (ProtocolException ex){
            Log.e(TAG, "ProtocolException : " + ex.getMessage());
        }catch(IOException ex){
            Log.e(TAG, "IOException : " + ex.getMessage());
        }catch (Exception ex){
            Log.e(TAG, "Exception : " + ex.getMessage());
        }
        return lsResponse;
    }

    public String convertStreamToString(InputStream poIs){
        StringBuilder oSb = new StringBuilder();
        BufferedReader oBReader = new BufferedReader(new InputStreamReader(poIs));
        String lsLine;

        try{
            while ((lsLine = oBReader.readLine())!=null){
                oSb.append(lsLine).append('\n');
            }
            Log.e(TAG, "IOException : " + oSb.toString());
        }catch (IOException ex){
            Log.e(TAG, "IOException : " + ex.getMessage());
        }finally {
            try{
                poIs.close();
            }catch (IOException ex){
                Log.e(TAG, "IOException : " + ex.getMessage());
            }
        }
        return oSb.toString();
    }
}
