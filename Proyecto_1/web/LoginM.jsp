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
            <span>Clinica San Diego</span>
        </header>
        <div>
            <div class="center">
                <h1>Inicio de Sesión</h1>
                <form method="post">
                    <div class="txt_field">
                        <input type="text" required>
                        <label>Nombre de usuario</label>
                    </div>
                    <div class="txt_field">
                        <input type="text" required>
                        <label>Contraseña</label>
                    </div>
                    <div class="pass">¿Olvidó la contraseña?</div>
                    <input type="submit" value="Iniciar Sesión">
                    <div class="signup_link">
                        ¿No está registrado?<a href="RegistroM.jsp">Regístrate</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
