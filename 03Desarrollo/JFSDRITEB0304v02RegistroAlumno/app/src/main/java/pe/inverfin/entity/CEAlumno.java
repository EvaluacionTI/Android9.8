package pe.inverfin.entity;

public class CEAlumno {
    private String codigoAlumno;
    private String numeroDNI;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNumeroDNI() {
        return numeroDNI;
    }

    public void setNumeroDNI(String numeroDNI) {
        this.numeroDNI = numeroDNI;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CEAlumno{");
        sb.append("codigoAlumno='").append(codigoAlumno).append('\'');
        sb.append(", numeroDNI='").append(numeroDNI).append('\'');
        sb.append(", apellidoPaterno='").append(apellidoPaterno).append('\'');
        sb.append(", apellidoMaterno='").append(apellidoMaterno).append('\'');
        sb.append(", primerNombre='").append(primerNombre).append('\'');
        sb.append(", segundoNombre='").append(segundoNombre).append('\'');
        sb.append(", tercerNombre='").append(tercerNombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
