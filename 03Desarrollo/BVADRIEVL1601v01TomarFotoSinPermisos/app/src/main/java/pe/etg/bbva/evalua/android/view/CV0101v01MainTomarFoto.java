package pe.etg.bbva.evalua.android.view;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CV0101v01MainTomarFoto extends Activity {

    private ImageView oivFotoPredio;
    private Button oBotonTomarFoto;
    private static final int REQUEST_IMAGE_CAPTURE = 903;
//https://unprogramador.com/tomar-foto-en-android/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tomar_foto);

        oivFotoPredio = findViewById(R.id.id_iv_foto_predio);
        oBotonTomarFoto = findViewById(R.id.id_btn_tomar_foto);

        oBotonTomarFoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent oFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (oFotoIntent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(oFotoIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int piRequestCode, int piResultCode, Intent poData){
        if (piRequestCode == REQUEST_IMAGE_CAPTURE && piResultCode==RESULT_OK){
            Bundle oBundle = poData.getExtras();
            Bitmap oImagenBitmap = (Bitmap) oBundle.get("data");
            oivFotoPredio.setImageBitmap(oImagenBitmap);
        }
    }
}
