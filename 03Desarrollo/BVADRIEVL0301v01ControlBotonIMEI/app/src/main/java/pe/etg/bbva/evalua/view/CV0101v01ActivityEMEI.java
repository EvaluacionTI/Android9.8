package pe.etg.bbva.evalua.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//http://blog.nubecolectiva.com/como-obtener-el-imei-de-un-movil-en-android-studio/
public class CV0101v01ActivityEMEI extends Activity {
    private TextView oTextViewMostrarIMEI;
    private Button oButtonGetIMEI;
    private String sCodigoImei;
    private static ArrayList<String> numbers;
    private static final Integer PHONESTATE = 0X1;
    private final String TAG = CV0101v01ActivityEMEI.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0101v01_emei);

        oTextViewMostrarIMEI = findViewById(R.id.id_textView_numero_emai);
        oButtonGetIMEI = findViewById(R.id.id_button_traer_imei);

        numbers = new ArrayList<String>();
        oButtonGetIMEI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View poView){
                queryPermission(Manifest.permission.READ_PHONE_STATE, PHONESTATE);
                oTextViewMostrarIMEI.setText(sCodigoImei);
            }
        });
    }

   // Con este método mostramos en un Toast con un mensaje que el usuario ha concedido los permisos a la aplicación
    private void queryPermission(String permission, Integer requestCode){
        if (ContextCompat.checkSelfPermission(CV0101v01ActivityEMEI.this, permission)!=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(CV0101v01ActivityEMEI.this, permission)){
                ActivityCompat.requestPermissions(CV0101v01ActivityEMEI.this, new String[]{permission}, requestCode);
            }else{
                ActivityCompat.requestPermissions(CV0101v01ActivityEMEI.this, new String[]{permission}, requestCode);
            }
        }else{
            sCodigoImei = getIMEI();
            Toast.makeText(this, permission + " : El permiso a la aplicación esta concedido", Toast.LENGTH_SHORT).show();
        }
    }

    // Con este método consultamos al usuario si nos puede dar acceso a leer los datos internos del móvil
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] granResults){
        switch (requestCode){
            case 1:
                // Validamos si el usuario acepta el permiso para que la aplicación acceda a los datos internos del equipo, si no denegamos el acceso
                if (granResults.length > 0 && granResults[0]==PackageManager.PERMISSION_GRANTED){
                    sCodigoImei = getIMEI();
                }else{
                    Toast.makeText(CV0101v01ActivityEMEI.this, "Has negado el permiso a la aplicación", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    @SuppressLint("MissingPermission")
    public String getIMEI(){
        final TelephonyManager telefonoManager= (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String sResult = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Hacemos la validación de métodos, ya que el método getDeviceId() ya no se admite para android Oreo en adelante, debemos usar el método getImei()
            sResult = telefonoManager.getImei();
        }else{
            sResult =  telefonoManager.getDeviceId();
        }
        return sResult;
    }
}
