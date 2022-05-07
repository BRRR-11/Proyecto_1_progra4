<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Paciente" %>
<%@page import="java.io.IOException" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.util.Properties" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="javax.naming.NamingException" %>
<%@page import="javax.sql.DataSource" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Registro.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica Tinder</span>
        </header>
        <div>
            <div class="center">
                <h1>Inicio de Sesión</h1>
                <form action="ServletAgregar" method="POST">
                    <div class="txt_field">
                        <input type="text" required name="nombre">
                        <label>Nombre</label>
                    </div>
                    <div class="txt_field">
                        <input type="text" required name="apellido">
                        <label>Apellido</label>
                    </div>
                    <div class="txt_field">
                        <input type="text" required name="cedula">
                        <label>Cedula</label>
                    </div>
                    <div class="txt_field">
                        <input type="text" required name="clave">
                        <label>Contraseña</label>
                    </div>
                    <div class="botonCen">
                        <input type="submit" value="Crear Usuario">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>