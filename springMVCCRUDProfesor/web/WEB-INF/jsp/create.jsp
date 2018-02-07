<%-- 
    Document   : edit
    Created on : Sep 7, 2015, 11:30:59 AM
    Author     : DanielEduardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" tye="text/css" href="{pageContext.request.contextPath}resources/css/estilos.css"
        -->
        <!-- <pring:url  value="/resources/css/estilos.css"/>-->
        <title>Crear Profesor</title>
    </head>
    <body>

        <f:form action="add.html" modelAttribute="Profesor">

            <label for="Idid">Id:</label>


            <input type="text" name="id" id="Idid" value=""/>
            <label for="nombreid">Nombre :</label>


            <input type="text" id="nombreid" name="nombre" value=""/>
            </br>
            <label for="correoid">correo:</label>

            <input type="email" id="correoid"name="correo" value=""/>
            <label for="telefonoid">Telefono:</label>

            <input type="text" id="telefonoid"name="telefono" value=""/>

            </br>
            <label for="direccionid">Direccion</label>

            <input type="text" id="direccionid" name="direccion" value=""/>

            <label for="nacimientoid">Fecha de nacimiento</label>

            <input type="text" id="nacimientoid" name="nacimiento" value=""/>


            <input type="submit" value="Save"/>
        </f:form>

    </body>
</html>

