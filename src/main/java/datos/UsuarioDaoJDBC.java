
package datos;

import entidad.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoJDBC implements IUsuario{
    
    private static final String SELECT_SQL=" SELECT id,usuario,clave,fecha_registro,estado"
            +" from tb_usuario";
    
    private static final String SELECT_SQL_BY_ID ="SELECT id,usuario,clave,fecha_registro,estado"
            +" from tb_usuario where usuario=?";
    
    private static final String SQL_INSERT = "INSERT INTO tb_usuario(usuario,clave,fecha_registro,estado)"
            +" VALUES(?,?,?,?,?)";
    
    private static final String SQL_UPDATE = " UPDATE tb_usuario set usuario=?, "
            +" clave=?, fecha_registro=?,estado=? WHERE id=? " ;
    
    private static final String SQL_DELETE = "DELETE FROM tb_usuario WHERE id=?";
    
    public List<Usuario> listar(){
        
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SELECT_SQL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String dusuario = rs.getString("usuario");
                String dclave = rs.getString("clave");
                String fecha_registro = rs.getString("fecha_registro");
                int estado = rs.getInt("estado");
                
                usuario = new Usuario(id,dusuario,dclave,fecha_registro,estado);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return usuarios;
        
    }
    
    public Usuario encontrar(Usuario usuario){
        
        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SELECT_SQL_BY_ID);
            pstmt.setString(1, usuario.getUsuario());
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String dusuario = rs.getString("usuario");
                String dclave = rs.getString("clave");
                String fecha_registro = rs.getString("fecha_registro");
                int estado = rs.getInt("estado");
                
                usuario.setId(id);
                usuario.setUsuario(dusuario);
                usuario.setClave(dclave);
                usuario.setFecha_registro(fecha_registro);
                usuario.setEstado(estado);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(pstmt);
            Conexion.close(rs);
            
        }
        
        return usuario;
        
    }
    
    public int insertar(Usuario usuario){
        
        Connection conn=null;
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getClave());
            pstmt.setString(3, usuario.getFecha_registro());
            pstmt.setInt(4, usuario.getEstado());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(Usuario usuario){
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getClave());
            pstmt.setString(4, usuario.getFecha_registro());
            pstmt.setInt(5, usuario.getEstado());
            pstmt.setInt(6, usuario.getId());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(Usuario usuario){
        
        Connection conn=null;
        PreparedStatement pstmt=null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, usuario.getId());
            rows = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
}
