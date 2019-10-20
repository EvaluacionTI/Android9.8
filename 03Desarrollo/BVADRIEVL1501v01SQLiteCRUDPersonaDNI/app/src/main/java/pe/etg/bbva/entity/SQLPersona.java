package pe.etg.bbva.entity;

public class SQLPersona {
    public static final String SQL_DB = "BBVARQUITECTURA";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS APXt01_persona";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE APXt01_persona(" +
            "tipo_documento TEXT, " +
            "numero_documento TEXT NOT NULL PRIMARY KEY, " +
            "apellido_nombre TEXT, " +
            "ciudad TEXT)";

    // Tablas Persona
    public static final String TABLE_PERSONA = "APXt01_persona";
    // Mensaje de error
    public static final String OK_GRABAR = "Se registró correctamente";
    public static final String WRN_NO_EXISTE = "No existe ningun registro para el documento elegido";
    public static final String OK_ELIMINAR = "Se eliminó el registro";
    // Consulta
    public static final String SQL_SELECT_BY_ID = "SELECT tipo_documento, numero_documento, apellido_nombre, ciudad FROM APXt01_persona WHERE numero_documento = ";
}
