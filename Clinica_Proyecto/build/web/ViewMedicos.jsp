<%-- 
    Document   : ViewMedicos
    Created on : 05/05/2022, 11:37:16 PM
    Author     : Admin
--%>

//<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Medico"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Registro.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica San Tinder</span>
        </header>
        <div class="center">
            <%
                                final String ruta_propiedades
                                        = "/cr/ac/una/eif209/ejemplo2/db.properties";
                                final String seleccion
                                        = "SELECT * FROM medico;";

                                Properties p = new Properties();
                                p.loadFromXML(getClass().getResourceAsStream(ruta_propiedades));
                                InitialContext ctx = new InitialContext();
                                DataSource db = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));

                            try {
                                try (Connection cnx = db.getConnection();
                                    Statement stm = cnx.createStatement();
                                    ResultSet rs = stm.executeQuery(seleccion)) {
                                    while (rs.next()) {
                                        Medico medico = new Medico(
                                                rs.getString("cedula"),
                                                rs.getString("nombre"),
                                                rs.getString("apellido"),
                                                rs.getString("clave"),
                                                rs.getString("telefono"),
                                                rs.getString("direccion"),
                                                rs.getString("idEspecialidad"),
                                                rs.getInt("frecuenciaCita")

                                        );
                                        out.println(String.format("\t%s<br />%n", medico));
                                    }
                                }
                            } catch (IOException | NullPointerException | SQLException ex) {
                                out.println(String.format("\tExcepción: '%s'%n", ex.getMessage()));
                            }
                        %>
            </div>
    </body>
</html>
