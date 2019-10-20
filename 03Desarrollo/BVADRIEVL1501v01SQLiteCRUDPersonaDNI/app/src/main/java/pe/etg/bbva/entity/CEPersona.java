package pe.etg.bbva.entity;

public class CEPersona {
    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidoNombres;
    private String ciudad;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApellidoNombres() {
        return apellidoNombres;
    }

    public void setApellidoNombres(String apellidoNombres) {
        this.apellidoNombres = apellidoNombres;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CEPersona{");
        sb.append("tipoDocumento='").append(tipoDocumento).append('\'');
        sb.append(", numeroDocumento='").append(numeroDocumento).append('\'');
        sb.append(", apellidoNombres='").append(apellidoNombres).append('\'');
        sb.append(", ciudad='").append(ciudad).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
