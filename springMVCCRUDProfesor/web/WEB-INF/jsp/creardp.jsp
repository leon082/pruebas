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
        <!--<link rel="stylesheet" tye="text/css" href="{pageContext.request.contextPath}WEB-INF/css/estilos.css"
            -->
         <!-- <pring:url  value="/resources/css/estilos.css"/>-->
        <title>Crear Departamento</title>
    </head>
    <body>

        <f:form action="adddp.html" modelAttribute="Departamento">

            <label for="Idid">Id:</label>
            <input type="text" name="id" id="Idid" value=""/>
            <label for="nombreid">Nombre :</label>


            <input type="text" id="nombreid" name="nombre" value=""/>
           
            <input type="submit" value="Save"/>
        </f:form>

    </body>
</html>

