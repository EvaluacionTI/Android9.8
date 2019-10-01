package pe.etg.bbva.android.utility;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.etg.bbva.android.entity.CECanal;

public class CUConvertir {

    public String concatenarTexto(String psCodigo, String psAbreviatura, String psDescripcion){
        return psCodigo + "|" + psAbreviatura + "|" + psDescripcion;
    }

    public String concatenarTexto(CECanal poCECanal){
        return  poCECanal.getCodigo() + "|" +
                poCECanal.getAbrevitura() + "|" +
                poCECanal.getDescripcion();
    }

    public SpannableStringBuilder colorTextoSeparador(CECanal poCECanal, String psSeparador){

        SpannableStringBuilder oSSB = new SpannableStringBuilder();
        SpannableString oSS1 = new SpannableString(poCECanal.getCodigo());
        oSS1.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, poCECanal.getCodigo().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(psSeparador);
        oSS1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(poCECanal.getAbrevitura());
        oSS1.setSpan(new ForegroundColorSpan(Color.GREEN), 0, poCECanal.getAbrevitura().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(psSeparador);
        oSS1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(poCECanal.getDescripcion());
        oSS1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, poCECanal.getDescripcion().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        return oSSB;
    }

    public SpannableStringBuilder tipoLetraSeparador(CECanal poCECanal, String psSeparador){
        String sCadena = poCECanal.getCodigo() + psSeparador + poCECanal.getAbrevitura() + psSeparador + poCECanal.getDescripcion();

        SpannableStringBuilder oSSB = new SpannableStringBuilder();
        SpannableString oSS1 = new SpannableString(poCECanal.getCodigo());
        oSS1.setSpan(new StyleSpan(Typeface.NORMAL), 0, poCECanal.getCodigo().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(psSeparador);
        oSS1.setSpan(new StyleSpan(Typeface.BOLD), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(poCECanal.getAbrevitura());
        oSS1.setSpan(new StyleSpan(Typeface.ITALIC), 0, poCECanal.getAbrevitura().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(psSeparador);
        oSS1.setSpan(new StyleSpan(Typeface.BOLD), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        oSS1 = new SpannableString(poCECanal.getDescripcion());
        oSS1.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, poCECanal.getDescripcion().length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        oSSB.append(oSS1);

        return oSSB;
    }
}

