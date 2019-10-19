package bbva.etg.pe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton oTogBtnApx, oTogBtnHost;
    private Button oBtnChangeState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oTogBtnApx = (ToggleButton) findViewById(R.id.id_toggleButton_off_apx);
        oTogBtnHost = (ToggleButton) findViewById(R.id.id_toggleButton_off_host);
        oBtnChangeState = (Button) findViewById(R.id.id_button_procesar);
    }

    public void changeState(View view) {
        if (oTogBtnApx.isActivated()==true){
            oTogBtnApx.setChecked(true);
            oTogBtnApx.setTextOff("APX Off");
            oTogBtnApx.setTextOn("APX ON");
        }else{
            oTogBtnApx.setChecked(false);
            oTogBtnApx.setTextOff("APX Off i");
            oTogBtnApx.setTextOff("APX ON i");
        }
        if(oTogBtnHost.isActivated()==true) {
            oTogBtnHost.setChecked(true);
            oTogBtnHost.setTextOff("Host Off");
            oTogBtnHost.setTextOn("Host ON");
        }else{
            oTogBtnHost.setChecked(true);
            oTogBtnHost.setTextOff("Host Off i");
            oTogBtnHost.setTextOn("Host ON i");
        }
    }
}
