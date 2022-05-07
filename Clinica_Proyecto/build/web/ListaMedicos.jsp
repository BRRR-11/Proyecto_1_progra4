
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/ListaMedicos.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica Tinder</span>
        </header>

        <div class="row">
            <h2 class="bienvenido">Ediitar Especialidad Medico</h2>
        
        <div class="section1">
            <div class= "p1">
                <form action="ServletEditM" method="POST">
                    <div class="txt_field">
                        <input type="text" required name="cedula">
                        <label>Cedula</label>
                    </div>
                    <div class="txt_field">
                        <input type="text" required name="especialidad">
                        <label>Especialidad</label>
                    </div>
                     <input type="submit" value="Cambiar especialidad">
            </form>
            </div>
        </div>      
        
    </body>
</html>
