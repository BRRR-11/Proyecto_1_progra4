<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="ServletRegistro" method="POST">
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
                    <div class="txt_field">
                        <input type="text" required name="clave1">
                        <label>Confirme la Contraseña</label>
                    </div>
                    <div class="botonCen">
                        <input type="submit" value="Crear Usuario">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>