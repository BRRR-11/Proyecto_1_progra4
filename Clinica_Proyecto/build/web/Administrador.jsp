

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Pagina2.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica San Diego</span>
        </header>

        <div class="row">
            <h2 class="bienvenido">Le damos la bienvenida al área administrativa</h2>
        </div>
        <div class="section1">
            <div class="row">
                <div class="centrar">
                    <div class="column">
                        <div class= "p1">
                            <h3><strong>Listar médicos</strong></h3>
                            <a href="ListaMedicos.jsp">
                                <button class="button button1">Ingresar</button>
                            </a>
                        </div>
                    </div>

                    <div class="column">
                        <div class= "p2">
                            <h3><strong>Listar especialidades</strong></h3>
                            <a href="ViewEsp.jsp">
                            <button class="button button1">listar</button>
                        </div>
                    </div>

                </div>
            </div>
            <div class="row">
                <div class="abajo">
                    <div class="column">
                        <div class= "p3">
                            <h3><strong>Listar ubicaciones</strong></h3>
                            <a href="viewUbic.jsp">
                                <button class="button button1">listar</button>
                            </a>
                        </div>
                    </div>
                    <div class="column">
                        <div class= "p4">
                            <h3><strong>Nuevo registro</strong></h3>
                            <button class="button button1">registrar</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
         <div></div>
    </body>
</html>
