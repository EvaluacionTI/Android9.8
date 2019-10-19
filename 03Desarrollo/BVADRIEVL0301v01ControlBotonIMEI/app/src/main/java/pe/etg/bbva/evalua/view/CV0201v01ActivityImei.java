package pe.etg.bbva.evalua.view;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CV0201v01ActivityImei extends AppCompatActivity {
    private TextView oTextViewMostrarIMEI;
    private Button oButtonGetIMEI;
    private String sCodigoImei;
    private static ArrayList<String> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0201v01_imei);
    }
}
