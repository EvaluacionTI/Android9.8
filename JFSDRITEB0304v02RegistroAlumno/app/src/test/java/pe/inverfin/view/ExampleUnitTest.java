package pe.inverfin.view;

import org.junit.Test;

import pe.inverfin.entity.CEAlumno;
import pe.inverfin.utility.CUArmaCadena;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private CUArmaCadena oCUArmarCadena;

    @Test
    public void addition_isCorrect() {
        String lsResultExpected = null;

        lsResultExpected = "CEAlumno{codigoAlumno='DNU199', numeroDNI='22082019', " +
                "apellidoPaterno='diaz', apellidoMaterno='vega', " +
                "primerNombre='illari', segundoNombre='laskhmi', tercerNombre='isabel'}";
        CEAlumno oRegistroAlumno = new CEAlumno();

        oRegistroAlumno.setCodigoAlumno("DNU199");
        oRegistroAlumno.setNumeroDNI("22082019");
        oRegistroAlumno.setApellidoPaterno("diaz");
        oRegistroAlumno.setApellidoMaterno("vega");
        oRegistroAlumno.setPrimerNombre("illari");
        oRegistroAlumno.setSegundoNombre("laskhmi");
        oRegistroAlumno.setTercerNombre("isabel");

        assertEquals(lsResultExpected, oRegistroAlumno.toString());
    }

    @Test
    public void concatenar_isCorrect(){
        String lsResultExpected = null;
        oCUArmarCadena = new CUArmaCadena();

        lsResultExpected = "DNU199|22082019|DiaZ|VegA|IllarI|LaskhmI|IsabeL";
        CEAlumno oRegistroAlumno = new CEAlumno();

        oRegistroAlumno.setCodigoAlumno("DNU199");
        oRegistroAlumno.setNumeroDNI("22082019");
        oRegistroAlumno.setApellidoPaterno("diaz");
        oRegistroAlumno.setApellidoMaterno("vega");
        oRegistroAlumno.setPrimerNombre("illari");
        oRegistroAlumno.setSegundoNombre("laskhmi");
        oRegistroAlumno.setTercerNombre("isabel");


        assertEquals(lsResultExpected, oCUArmarCadena.concatenarCadena(oRegistroAlumno));
    }
}