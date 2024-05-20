
package controlador;

import datos.IUsuario;
import datos.UsuarioDaoJDBC;
import entidad.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    
        HttpSession sesion;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String accion = request.getParameter("accion");
        
        if(accion!=null){
        
            switch(accion){
                case "cerrar":
                    sesion = request.getSession();
                    sesion.invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                default:
                    
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
                    
        }
                    
        /*List<Usuario> usuarios = new UsuarioDaoJDBC().listar();
        System.out.println("usuarios=" + usuarios);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        */
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String accion = request.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "ingresar":
                
                 
                Usuario usu = new Usuario(usuario,clave);
                IUsuario iusu = new UsuarioDaoJDBC();
                        iusu.encontrar(usu);
                sesion = request.getSession();
                sesion.setAttribute("session_usuario", usu.getUsuario());
                request.setAttribute("usuario", usu);

                
                List<Usuario> usuarios = iusu.listar(); //prueba con rama v2.2
                request.setAttribute("usuarios", usuarios);

                request.getRequestDispatcher("principal.jsp").forward(request, response);
                
                break;
                
                case "cerrar": //cerrar probando v2.2
                    
                    sesion = request.getSession();
                    sesion.invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    
                break;
                    
                default:
                    
            }
        }
        
        //System.out.println(usu.getId());
        
        //System.out.println("usuario = "+usuario);
    }
    
    
}
