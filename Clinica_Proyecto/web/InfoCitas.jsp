<%-- 
    Document   : InfoCitas
    Created on : 07/05/2022, 07:05:47 PM
    Author     : Admin
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Registro.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica San Tinder</span>
        </header>
        <div class="center">
         <form action="ServletListaCita" method="POST">
                 <div class="txt_field">
                 <input type="text" required name="cedula">
                 <label>Digite numero de cedula del medico</label>
                </div>
                 <div class="botonCen">
                        <input type="submit" value="Busca">
                 </div>
                 <div>
            <%
              
                Cita obj = new Cita();
                obj = (Cita) request.getAttribute("objController");
                if (obj != null) {
                    out.print(obj.getId_Medico());
                    out.print(obj.getId_Paciente());
                    out.print(obj.getHora());
                    out.print(obj.getEstado());
                }

            %>
                 </div>
            </form>
           </div>
    </body>
</html>
