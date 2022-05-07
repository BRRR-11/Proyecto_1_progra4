<%-- 
    Document   : CrearCita
    Created on : 6 may. 2022, 15:53:38
    Author     : ariqq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/Registro.css" rel="stylesheet" type="text/css" />
        <title>Crear Cita</title>
    </head>
    <header class="titulo">
            <img width="100" height="100" style="margin-right: 1em; vertical-align: middle;" src="img/hospital.png"/>
            <span>Clinica Tinder</span>
    </header>
    <body>
        <div class="center">
            <form action="ServletCrearCita" method="POST">
                <div class="txt_field">
                    <input type="text" required name="id_Medico">
                    <label>Id Medico</label>
                </div>
                <div class="txt_field">
                    <input type="text" required name="id_Paciente">
                    <label>Id Paciente</label>
                </div>
                <div class="txt_field">
                    <input type="text" required name="hora">
                    <label>Hora</label>
                </div>
                <div class="txt_field">
                    <input type="text" required name="estado">
                    <label>Estado</label>
                </div>
                <div class="botonCen">
                    <input type="submit" value="Agregar Cita">
                </div>

            </form>
        </div>
    </body>
</html>
