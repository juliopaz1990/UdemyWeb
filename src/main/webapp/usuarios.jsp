
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Usuarios</title>
    </head>
    <body>
        <h1>Lista Usuarios</h1>
        <ul>
            <c:forEach var="usuario" items="${usuarios}">
                <li>${usuario.id} ${usuario.usuario} ${usuario.clave} ${usuario.fecha_registro} ${usuario.estado}</li>                
            </c:forEach>
        </ul>
    </body>
</html>
