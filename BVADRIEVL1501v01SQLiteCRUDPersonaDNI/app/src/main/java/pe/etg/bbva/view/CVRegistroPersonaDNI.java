package pe.etg.bbva.view;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

import pe.etg.bbva.entity.CEPersona;
import pe.etg.bbva.entity.SQLPersona;
import pe.etg.bbva.model.CDAdminSQLiteOpenHelper;

public class CVRegistroPersonaDNI extends AppCompatActivity {
// https://androidstudiofaqs.com/tutoriales/usar-sqlite-en-android-studio

    private EditText oEtNumero, oEtTipo, oEtApellido, oEtCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvregistro_persona_dni);

        oEtTipo = (EditText) findViewById(R.id.id_et_tipo_documento);
        oEtNumero = (EditText) findViewById(R.id.id_et_numero_documento);
        oEtApellido = (EditText) findViewById(R.id.id_et_apellidos_nombres);
        oEtCiudad = (EditText) findViewById(R.id.id_et_ciudad);
    }

    //1. Alta
    public void createPerson(View pView){
        CDAdminSQLiteOpenHelper oCDSQLiteOpenHelper = new CDAdminSQLiteOpenHelper(this, SQLPersona.SQL_DB, null, 1);
        SQLiteDatabase oBDSQLite = oCDSQLiteOpenHelper.getWritableDatabase();

        CEPersona oPersona = new CEPersona();

        oPersona.setTipoDocumento(oEtTipo.getText().toString());
        oPersona.setNumeroDocumento(oEtNumero.getText().toString());
        oPersona.setApellidoNombres(oEtApellido.getText().toString());
        oPersona.setCiudad(oEtCiudad.getText().toString());

        ContentValues oRegistro = new ContentValues();

        oRegistro.put("tipo_documento",oPersona.getTipoDocumento());
        oRegistro.put("numero_documento",oPersona.getNumeroDocumento());
        oRegistro.put("apellido_nombre",oPersona.getApellidoNombres());
        oRegistro.put("ciudad",oPersona.getCiudad());


        // los inserto en la base de datos
        oBDSQLite.insert(SQLPersona.TABLE_PERSONA, null, oRegistro);
        oBDSQLite.close();

        // ponemos los campos a vacío para insertar el siguiente usuario
        clearField();

        Toast.makeText(this, SQLPersona.OK_GRABAR, Toast.LENGTH_SHORT).show();
    }

    private void clearField(){
        oEtTipo.setText("");
        oEtNumero.setText("");
        oEtApellido.setText("");
        oEtCiudad.setText("");
    }

   //2. Listar
    public void listPerson(View poView){
        CDAdminSQLiteOpenHelper oCDSQLiteOpenHelper = new CDAdminSQLiteOpenHelper(this, SQLPersona.SQL_DB, null, 1);
        SQLiteDatabase oBDSQLite = oCDSQLiteOpenHelper.getWritableDatabase();

        String numeroDocumento = oEtNumero.getText().toString();
        Cursor oRow = oBDSQLite.rawQuery(SQLPersona.SQL_SELECT_BY_ID + numeroDocumento, null);
        if (oRow.moveToFirst()) {
            oEtTipo.setText(oRow.getString(0));
            oEtApellido.setText(oRow.getString(2));
            oEtCiudad.setText(oRow.getString(3));
        } else
            Toast.makeText(this, SQLPersona.WRN_NO_EXISTE, Toast.LENGTH_SHORT).show();
        oBDSQLite.close();
    }


    //3. Actualizar
    public void updatePerson(View poV){
        CDAdminSQLiteOpenHelper oCDSQLiteOpenHelper = new CDAdminSQLiteOpenHelper(this, SQLPersona.SQL_DB, null, 1);
        SQLiteDatabase oBDSQLite = oCDSQLiteOpenHelper.getWritableDatabase();

        CEPersona oPersona = new CEPersona();

        oPersona.setTipoDocumento(oEtTipo.getText().toString());
        oPersona.setNumeroDocumento(oEtNumero.getText().toString());
        oPersona.setApellidoNombres(oEtApellido.getText().toString());
        oPersona.setCiudad(oEtCiudad.getText().toString());

        ContentValues oRegistro = new ContentValues();
        // actualizamos con los nuevos datos, la información cambiada
        oRegistro.put("tipo_documento",oPersona.getTipoDocumento());
        oRegistro.put("ape llido_nombre",oPersona.getApellidoNombres());
        oRegistro.put("ciudad",oPersona.getCiudad());

        int iCantidad = oBDSQLite.update(SQLPersona.TABLE_PERSONA, oRegistro, "numero_documento=" + oPersona.getNumeroDocumento(), null);
        oBDSQLite.close();

        if (iCantidad == 1)
            Toast.makeText(this, SQLPersona.OK_GRABAR, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, SQLPersona.WRN_NO_EXISTE, Toast.LENGTH_SHORT).show();
    }

    //4. Eliminar
    public void deletePerson(View poV){
        CDAdminSQLiteOpenHelper oCDSQLiteOpenHelper = new CDAdminSQLiteOpenHelper(this, SQLPersona.SQL_DB, null, 1);
        SQLiteDatabase oBDSQLite = oCDSQLiteOpenHelper.getWritableDatabase();

        String numeroDocumento = oEtNumero.getText().toString();
        // aquí borro la base de datos del usuario por el dni
        int iCantidad = oBDSQLite.delete(SQLPersona.TABLE_PERSONA, "numero_documento=" + numeroDocumento, null);
        oBDSQLite.close();

        clearField();
        if (iCantidad == 1)
            Toast.makeText(this, SQLPersona.OK_ELIMINAR, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, SQLPersona.WRN_NO_EXISTE, Toast.LENGTH_SHORT).show();
    }

    public void backupBD() throws IOException {

        //String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        final String inFileName ="/data/data/pe.etg.bbva.view/databases/"+SQLPersona.SQL_DB;
        File dbFile= new File(inFileName);
        FileInputStream fis=null;
        fis=new FileInputStream(dbFile);
        String directorio = "Definir directorio para copiar en c o d";
        File d = new File(directorio);
        if (!d.exists()) {
            d.mkdir();
        }

        //String outFileName=directorio + "/" +SQLPersona.SQL_DB +""+timeStamp;
        String outFileName=directorio + "/" +SQLPersona.SQL_DB;
        OutputStream output = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        output.flush();
        output.close();
        fis.close();

    }
}
