<%-- 
    Document   : edit
    Created on : Sep 7, 2015, 11:30:59 AM
    Author     : DanielEduardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT</title>
    </head>
    <body>

        <f:form action="updatedp.html" modelAttribute="Profesor">
            <input type="hidden" name="id" value="${dp.id}"/>
            <label for="nombreid">Nombre:</label>
            <input type="text" name="nombre" value="${dp.nombre}" id="nombreid"/>
            
             
            <input type="submit" id="nombredptid" value="Save"/>
        </f:form>
            

    </body>
</html>

