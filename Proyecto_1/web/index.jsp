<%-- 
    Document   : index
    Created on : 20 abr. 2022, 19:45:36
    Author     : ariqq
--%>

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
                    <a href="Pagina2.jsp">
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
                    <a href="Administrador.jsp">
                        <button class="button button1">Ingresar</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
