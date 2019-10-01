package pe.bbva.evalua.android4.entity;

public class CERowItemUserFoto {
    private String usuario;
    private int foto;

    public  CERowItemUserFoto(){}

    public CERowItemUserFoto(String psUsuario, int piFoto){
        this.usuario = psUsuario;
        this.foto = piFoto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                ", foto=" + foto +
                '}';
    }
}

