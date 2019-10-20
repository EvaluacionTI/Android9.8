package pe.etg.bbva.evalua.android.entity;

public class CERowItemUserFoto {
    private String usuario;
    private String descripcion;
    private int foto;

    public CERowItemUserFoto(){}

    public CERowItemUserFoto(String psUsuario, String psDescripcion, int piFoto){
        this.setUsuario(psUsuario);
        this.setDescripcion(psDescripcion);
        this.setFoto(piFoto);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "CERowItemUserFoto{" +
                "usuario='" + usuario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto=" + foto +
                '}';
    }
}