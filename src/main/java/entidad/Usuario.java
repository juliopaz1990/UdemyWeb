
package entidad;

public class Usuario {
    
    private int id;
    private String usuario;
    private String clave;
    private String fecha_registro;
    private int estado;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    

    public Usuario(String usuario, String clave, String fecha_registro, int estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public Usuario(int id, String usuario, String clave, String fecha_registro, int estado) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", fecha_registro=" + fecha_registro + ", estado=" + estado + '}';
    }

    
    
    
    
}
