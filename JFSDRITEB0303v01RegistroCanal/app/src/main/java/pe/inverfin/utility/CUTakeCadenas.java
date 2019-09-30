package pe.inverfin.utility;

import pe.inverfin.entity.CECanal;

public class CUTakeCadenas {

    public String getConcatenarCadena(CECanal poCECanal){
        return poCECanal.getCodigo() + "|" + poCECanal.getAbreviatura() + "|" + poCECanal.getDescripcion();
    }
}
