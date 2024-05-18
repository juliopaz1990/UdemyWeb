/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Usuario;
import java.util.List;

/**
 *
 * @author julio
 */
public interface IUsuario {
    
    
    List<Usuario> listar();
    
    Usuario encontrar(Usuario usuario);
    
    int insertar(Usuario usuario);
    
    int actualizar(Usuario usuario);
    
    int eliminar(Usuario usuario);
    
    
}
