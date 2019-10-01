package pe.inverfin.utility;

import android.util.Log;

import pe.inverfin.entity.CEAlumno;

public class CUArmaCadena {
    private static final String TAG = "CUArmaCadena";

    public String concatenarCadena(CEAlumno poCEAlumno){
        Log.i(TAG, poCEAlumno.toString());
        return poCEAlumno.getCodigoAlumno() + "|" +
                poCEAlumno.getNumeroDNI() + "|" +
                getUpperCaseFirstLast(poCEAlumno.getApellidoPaterno()) + "|" +
                getUpperCaseFirstLast(poCEAlumno.getApellidoMaterno()) + "|" +
                getUpperCaseFirstLast(poCEAlumno.getPrimerNombre()) + "|" +
                getUpperCaseFirstLast(poCEAlumno.getSegundoNombre()) + "|" +
                getUpperCaseFirstLast(poCEAlumno.getTercerNombre());
    }

    public String getUpperCaseFirstLast(String psCadena){

        String sFirtUpperCase = "", sLastUpperCase = "", lsConversionUpperCase = "";
        char sFirstCharacter, sSecondCharacter;
        int iLastCharacter = psCadena.length()-1;

        sFirstCharacter = psCadena.charAt(0);
        sSecondCharacter = psCadena.charAt(iLastCharacter);

        if (!Character.isUpperCase(sFirstCharacter)){
            sFirtUpperCase = String.valueOf(sFirstCharacter).toUpperCase();
        }

        if (!Character.isUpperCase(sSecondCharacter)){
            sLastUpperCase = String.valueOf(sSecondCharacter).toUpperCase();
        }
        lsConversionUpperCase = sFirtUpperCase + psCadena.substring(1,iLastCharacter) + sLastUpperCase;

        Log.i(TAG, psCadena);
        Log.i(TAG, sFirtUpperCase);
        Log.i(TAG, sLastUpperCase);
        Log.i(TAG, psCadena.substring(1,iLastCharacter));
        Log.i(TAG, lsConversionUpperCase);

        return lsConversionUpperCase;
    }

}
