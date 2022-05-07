<%-- 
    Document   : Prueba
    Created on : 5 may. 2022, 13:59:03
    Author     : ariqq
--%>

<%@page import="javax.naming.NamingException"%>
<%@page import="cr.ac.una.eif209.servicios.ServletBuscar"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="ServletBuscar" method="POST">
            <div class="txt_field">
                <input type="text" required name="buscaCedula">
                <label>Cedula</label>
            </div>
            <div class="botonCen">
                <input type="submit" value="Buscar Paciente">
            </div>
            
        </form>
       <h1>Mostrar Informacion</h1>
    
    </body>

</html>
