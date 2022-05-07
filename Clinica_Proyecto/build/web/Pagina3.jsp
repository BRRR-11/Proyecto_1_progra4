<%-- 
    Document   : Pagina3
    Created on : 20 abr. 2022, 19:28:36
    Author     : ariqq
--%>

<%@page import="cr.ac.una.eif209.ejemplo2.modelo.Paciente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Area Paciente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Pagina3.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica San Tinder</span>
        </header>

        <div class="row">
            <h2 class="bienvenido">Le damos la bienvenida al área paciente</h2>
        </div>
        <div class="section1">
            <div class="row">
                <div class="centrar">
                    <div class="column">
                        <div class= "p1">
                            <h3><strong>Registro</strong></h3>
                            <button class="button button1">Ingresar</button>
                        </div>
                    </div>

                    <div class="column">
                        <div class= "p2">
                            <h3><strong>Busquedas</strong></h3>
                            <input type="text">
                        </div>
                    </div>

                </div>
            </div>
            <div class="row">
                <div class="abajo">
                    <div class="column">
                        <div class= "p3">
                            <h3><strong>Consultas citas disponibles</strong></h3>
                            <button class="button button1">Consultar</button>
                        </div>
                    </div>
                    <div class="column">
                        <div class= "p4">
                            <h3><strong>Agendar Cita</strong></h3>
                             <a href="CrearCita.jsp">
                                <button class="button button1">Ingresar</button>
                            </a>
                        </div>
                    </div>

                </div>
            </div>
            
        </div>
        
    </body>
</html>
