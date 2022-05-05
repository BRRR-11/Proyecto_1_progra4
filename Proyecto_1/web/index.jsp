<%-- 
    Document   : index
    Created on : 20 abr. 2022, 19:45:36
    Author     : ariqq
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="presentacion.logic.Paciente"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica Tinder</span>
        </header>

        <div class="row">
            <h2 class="bienvenido">Area de inicio de sesion</h2>
        </div>

        <div class="row">
            <div class="centrar">
                <div class="column">
                    <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
                    <h3><strong>Clinica</strong></h3>
                    <a href="LoginM.jsp">
                        <button class="button button1">Ingresar</button>
                    </a>
                </div>

                <div class="column">
                    <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
                    <h3><strong>Paciente</strong></h3>
                    <a href="Pagina4.jsp">
                        <button class="button button1">Ingresar</button>
                    </a>
                </div>

                <div class="column">
                    <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
                    <h3><strong>Administrador</strong></h3>
                    <a href="LoginA.jsp">
                        <button class="button button1">Ingresar</button>
                    </a>
                </div>
            </div>
        </div>
        <div>
            <%
                        try {
                            final String ruta_propiedades
                                    = "/presentacion/data/paciente.properties";
                            final String seleccion
                                    = "SELECT * FROM paciente ORDER BY cedula; ";

                            Properties p = new Properties();
                            p.loadFromXML(getClass().getResourceAsStream(ruta_propiedades));

                            InitialContext ctx = new InitialContext();
                            DataSource db = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));

                            try (Connection cnx = db.getConnection();
                                Statement stm = cnx.createStatement();
                                ResultSet rs = stm.executeQuery(seleccion)) {

                                while (rs.next()) {
                                    Paciente usuario = new Paciente(
                                            rs.getString("cedula"),
                                            rs.getString("nombre"),
                                            rs.getString("apellidos"),
                                            rs.getString("clave")
                                    );
                                    out.println(String.format("\t%s<br />%n", usuario));
                                }

                            }

                        } catch (IOException | NullPointerException | SQLException ex) {
                            out.println(String.format("\tExcepción: '%s'%n", ex.getMessage()));
                        }
                    %>
        </div>
    </body>
</html>
