package pe.etg.bbva.evalua.android.view.bvadrievl1602v01mostrarpdf;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class CV0101v01MostrarArchivoPDF extends AppCompatActivity {
//http://indyvision.net/android-snippets/android-using-intents-open-files/
//http://www.androidsnippets.com/open-any-type-of-file-with-default-intent.html
// https://www.codevoila.com/post/46/android-tutorial-android-external-storage
//http://www.sgoliver.net/blog/ficheros-en-android-i-memoria-interna/
//http://www.sgoliver.net/blog/ficheros-en-android-ii-memoria-externa-tarjeta-sd/
//https://lavaradelroboto.wordpress.com/2012/10/24/ficheros-androidlectura-y-escritura-en-memoria-externa/

    private Button oBotonMostrarPDF, oBotonSeleccionarPDF;
    private TextView oTvPath, oTvArchivo;
    private Boolean DisponibilySD = false;
    private Boolean AccessWriteSD = false;
    private List<String> oItemArchivos = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity0101v01_mostrar_archivo_pdf);

        oTvPath = findViewById(R.id.id_tv_path);
        oTvArchivo = findViewById(R.id.id_tv_archivo);
        //oBotonMostrarPDF = findViewById(R.id.id_);
        //oBotonSeleccionarPDF = findViewById(R.id.id_seleccionar_archivo_pdf);

    }

    //https://www.flipandroid.com/cmo-diferenciar-entre-la-ruta-de-la-tarjeta-sd-interna-y-externa-en-android.html
    //https://www.flipandroid.com/buscar-todos-los-archivos-en-la-tarjeta-sd.html
    // https://gist.github.com/PauloLuan/4bcecc086095bce28e22
//http://www.javased.com/index.php?api=android.os.Environment
    //https://www.programcreek.com/java-api-examples/?class=android.os.Environment&method=getExternalStorageDirectory
    //https://android.okhelp.cz/sd-card-get-external-storage-directory-android/
    //https://www.codevoila.com/post/46/android-tutorial-android-external-storage
    //https://stackoverflow.com/questions/39305757/why-does-getexternalstoragedirectory-return-my-phones-root-storage-not-the-sd/39305835
//https://developer.android.com/reference/android/os/Environment.html#getExternalStorageDirectory()
    //https://es.stackoverflow.com/questions/15481/mostrar-cuadro-de-di%C3%A1logo-para-selecionar-un-archivo-o-ruta-en-android

    public void mostrarEnvironment(View poView){
        String sInternalStorage = System.getenv("EXTERNAL_STORAGE");
        String sExternalStorage = System.getenv("SECONDARY_STORAGE");

        if (Environment.isExternalStorageRemovable()) {
            File oEnvironment = Environment.getExternalStorageDirectory();
            oTvPath.setText(oEnvironment.getPath());
        }else{
            String sDirectorioBase = Environment.getExternalStorageDirectory().toString();

            oTvPath.setText("Ruta : " + sDirectorioBase);
            oTvArchivo.setText("Estado : " + Environment.getExternalStorageState());
        }
    }

    public void mostrarDirectorioFijo(View poView){
        String sInternalStorage = System.getenv("EXTERNAL_STORAGE");
        String sDirectorioBase = Environment.getExternalStorageDirectory().toString();
        String sDirectorioBaseAbsolute = Environment.getExternalStorageDirectory().getAbsolutePath();

        File oDirectorio = new File(sInternalStorage + "/UNJFSC/Ebusines");
        File oFile = new File(sDirectorioBaseAbsolute + "/UNJFSC/Ebusines","SSN01-02 Sylabus E-Business.pdf");
        if (oDirectorio.isDirectory() && oFile.exists()){
            oTvPath.setText(oDirectorio.getPath());
            oTvArchivo.setText("SSN01-02 Sylabus E-Business.pdf");
        }else{
            oTvArchivo.setText("No existe directorio o Archivo");
        }
    }

    public void elegirArchivo(View poView){

        if (poView.getId() == R.id.id_btn_elegir_archivo){
            Toast.makeText(getApplicationContext(), "Iniciando en otra actividad." , Toast.LENGTH_LONG).show();
            Intent oIntento = new Intent(this, CV0201v01ElegirArchivo.class);
            startActivity(oIntento);
        }else{
            Toast.makeText(getApplicationContext(), "Actividad no corresponde " + poView.getId() , Toast.LENGTH_LONG).show();
        }

    }

//    @Override
//    protected void onActivityResult(int iRequestCode, int iResultCode, Intent poData){
//        super.onActivityResult(iRequestCode, iResultCode, poData);
//        if(iResultCode==RESULT_CANCELED){
//
//        }
//        if ((iResultCode==RESULT_OK) && (iRequestCode==VALOR_RETORNO)){
//            Uri uri = poData.getData();
//        }
//    }

    public void listarArchivos(View poView){
        oItemArchivos = new ArrayList<String>();
        File sDirectorio = Environment.getExternalStorageDirectory();
        String sDirectorioAbsoluteBase = Environment.getExternalStorageDirectory().getAbsolutePath();
        String sDirectorioBase = Environment.getExternalStorageDirectory().getPath();
        String sInternalStorage = System.getenv("EXTERNAL_STORAGE");

        File oPathArchivo = new File(sDirectorioBase + "/Download");
        File[] oArchivos = oPathArchivo.listFiles();

        for (int i=0; i <= oArchivos.length; i++){
            File oArchivo = oArchivos[i];
            if (oArchivo.isDirectory()){
                oItemArchivos.add(oArchivo.getName() + "/");
            }else{
                oItemArchivos.add(oArchivo.getName());
            }
        }
    }

    public void mostrarArchivoPDF(View poView){

        //verifySD();
        //if (DisponibilySD && AccessWriteSD){
            //writeFileMemoryExtern();
        //}else{
        //    if(DisponibilySD && !AccessWriteSD){
                //readFileMemoryExtern()
        //    }
        //}

        String sArchivo = "SSN01-02 Sylabus E-Business.pdf";
        String sPath_of_sdcard = Environment.getExternalStorageDirectory().toString();

        File oFile = new File(sPath_of_sdcard+"/UNJFSC/Ebusines",sArchivo);
        if (!oFile.exists()){
            oTvPath.setText("No existe archivo seleccionado PDF");
            Toast.makeText(getApplicationContext(), "El archivo no existe." , Toast.LENGTH_LONG).show();
            Log.e("Archivo ", "No existe archivo seleccionado PDF");
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                Uri oPath = FileProvider.getUriForFile(this,getPackageName()+".provider",oFile);
                Intent oIntentPdf = new Intent(Intent.ACTION_VIEW);
                oIntentPdf.setData(oPath);
                oIntentPdf.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                try{
                    Toast.makeText(this,"Abriendo PDF" + oPath, Toast.LENGTH_SHORT).show();
                    startActivity(oIntentPdf);
                }catch(RuntimeException ex){
                    Toast.makeText (this, "No se ha encontrado ningún lector de PDF en su dispositivo", Toast.LENGTH_SHORT) .show ();
                }
            }else{
                Uri oPath = Uri.fromFile(oFile);
                oTvPath.setText("URI Path : " + oPath.getEncodedPath());
                oTvArchivo.setText(oFile.getName());

                Intent oIntentPdf = new Intent(Intent.ACTION_VIEW);
                oIntentPdf.setDataAndType(oPath, "application/pdf");
                oIntentPdf.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                try{
                    Toast.makeText(this,"Abriendo PDF" + oPath, Toast.LENGTH_SHORT).show();
                    startActivity(oIntentPdf);
                }catch(RuntimeException ex){
                    Toast.makeText (this, "No se ha encontrado ningún lector de PDF en su dispositivo", Toast.LENGTH_SHORT) .show ();
                }
            }

//            catch(ActivityNotFoundException ex){
//                Toast.makeText(getApplicationContext(), "Activity Not Found" , Toast.LENGTH_LONG).show();
//                Log.i("Evaluación pdf : ","Error al iniciar activity", ex);
//            }


//            PackageManager gm = getPackageManager();
 //           ComponentName oComponet = oIntent.resolveActivity(gm);
  //          if (oComponet == null) {
    //            Log.e("PDF ", "No existe ninguna aplicación para abrir archivos PDF");
      //      } else {
        //        startActivity(oIntent);
          //  }
        }
    }

    private void verifySD(){
        String status = Environment.getExternalStorageState();

        // Tarjeta disponible tanto para leer como para escribir
        if (status.equals(Environment.MEDIA_MOUNTED)){
            DisponibilySD = true;
            AccessWriteSD = true;
            return;
        }else{
            //Tarjeta disponible solo para lectura
            if (status.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
                DisponibilySD = true;
                AccessWriteSD = false;
                return;
            }else{
                DisponibilySD = false;
                AccessWriteSD = false;
                return;
            }
        }
    }
}
