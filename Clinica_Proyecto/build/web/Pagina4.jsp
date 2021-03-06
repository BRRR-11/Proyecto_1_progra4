
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Login.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica San Tinder</span>
        </header>
        <div>
            <div class="center">
                <h1>Inicio de Sesión</h1>
                <form action="ServletLogin" method="POST">
                    <div class="txt_field">
                        <input type="text" required name="cedula">
                        <label>Cedula</label>
                    </div>
                    <div class="txt_field">
                        <input type="password" required name="clave">
                        <label>Contraseña</label>
                    </div>
                    <div class="pass">¿Olvidó la contraseña ?</div>
                    <input type="submit" value="Iniciar Sesión">
                    <div class="signup_link">
                        ¿No está registrado?<a href="Registro.jsp">Regístrate</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
