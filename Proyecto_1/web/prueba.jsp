<%-- 
    Document   : prueba
    Created on : 29 abr. 2022, 15:44:25
    Author     : ariqq
--%>

<%@page import="presentacion.logic.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <%
                Paciente obj = new Paciente();
                obj = (Paciente) request.getAttribute("objController");
                if (obj != null) {
                    out.print(obj.getCedula());
                    out.print(obj.getNombre());
                    out.print(obj.getApellido());
                    out.print(obj.getClave());
                }


            %>
        </div>
    </body>
</html>
