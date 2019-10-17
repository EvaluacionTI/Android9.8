package pe.inverfin.evalua.android4.service;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import pe.inverfin.evalua.android4.view.R;

public class CSServiceTask extends AsyncTask<Void, Void, Void> {
    private Context oContext;
    private String sLinkApi;

    private  CSServiceTask(Context poContext, String psLinkApi){
        this.oContext = poContext;
        this.sLinkApi = psLinkApi;
    }
    @Override
    protected void onPreExecute(){
        String lsMensaje = "Json Data is downloading .....!";
        super.onPreExecute();
        Toast.makeText(this.oContext, lsMensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected  void onPostExecute(Void poResult){
        super.onPostExecute(poResult);

    }
}
