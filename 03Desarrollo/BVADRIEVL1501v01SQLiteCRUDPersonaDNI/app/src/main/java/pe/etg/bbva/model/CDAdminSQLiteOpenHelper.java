package pe.etg.bbva.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.etg.bbva.entity.SQLPersona;

// 1. Generar las implementaciones
// 2. Generar el constructor
public class CDAdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public CDAdminSQLiteOpenHelper(Context pcontext, String pnombre, SQLiteDatabase.CursorFactory pFactory, int pVersion) {
        super(pcontext, pnombre, pFactory, pVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //3. Creamos la tabla de usuario (dni, numero, nombre, ciudad )
        db.execSQL(SQLPersona.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //4. Eliminamos la tabla si esta existe
        db.execSQL(SQLPersona.SQL_DROP_TABLE);
        db.execSQL(SQLPersona.SQL_CREATE_TABLE);

    }
}
