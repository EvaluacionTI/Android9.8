package pe.etg.bbva.utilidad;

import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import pe.etg.bbva.entidad.CECanal;
import pe.etg.bbva.view.R;

public class CUConvertir {

    public String armarTramaHtml(CECanal poCECanal){
        return  asignarColorHtml(poCECanal.getCodigo(),1) + "|" +
                asignarColorHtml(poCECanal.getAbrevitura(),2) + "|" +
                asignarColorHtml(poCECanal.getDescripcion(),3);
    }

    public String getAsignarColor(String psColor, String psTexto){
        return  psColor + psTexto;
    }

    public String asignarColorHtml(String psCadena, int piTipoColor){
//        String styledText = "<font color='purple'>" + sCadena + "</font>.";
//        Spanned result = Html.fromHtml(styledText);

        String sColorAsignado = null;

        switch (piTipoColor){
            case 1:
                sColorAsignado = "<FONT color='green'>" + psCadena + "</FONT>";
                break;
            case 2:
                sColorAsignado = "<FONT color='purple'>" + psCadena + "</FONT>";
                break;
            case 3:
                sColorAsignado = "<FONT color='yellow'>" + psCadena + "</FONT>";
                break;
        }

        return sColorAsignado;
    }

    public Spanned getFormatoColorHtml(String psCadena){
        return Html.fromHtml(psCadena);
    }

    public String armarTramaSpan(CECanal poCECanal){
        String sCadena;


        return  getFormateColorSpan(poCECanal.getCodigo(),1) + "|" +
                getFormateColorSpan(poCECanal.getAbrevitura(),2) + "|" +
                getFormateColorSpan(poCECanal.getDescripcion(),3);
    }

    /*
    Asignar color desde una posición inicial hasta una posición final
     */
    public Spannable getFormateColorSpan(String psCadena, int piTipoColor){
//        int colorBlue = getResources().getColor(R.color.colorBlue);
//        String text = getString(R.string.tv_codigo);
//        SpannableString spannable = new SpannableString(text);
//        spannable.setSpan(new ForegroundColorSpan(colorBlue), 0, text.length(), 0);
        int iColorAsignado=0;

        SpannableString spannable = new SpannableString(psCadena);

        switch (piTipoColor){
            case 1:
                iColorAsignado = Color.RED;
                break;
            case 2:
                iColorAsignado = Color.MAGENTA;
                break;
            case 3:
                iColorAsignado = Color.RED;
                break;
        }

        spannable.setSpan(new ForegroundColorSpan(iColorAsignado), 0, psCadena.length(), 0);

        return  spannable;
    }
}

