<%-- 
    Document   : edit
    Created on : 6/02/2018, 02:03:07 PM
    Author     : luis.leon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
    <f:form action="update.html" modelAttribute="TbPrograma">
        <input type="hidden" name="id" value="${programa.idPrograma}"/>
        <label for="nombreid">Nombre :</label>
        <input type="text" name="nombre" value="${programa.descripcion}" id="nombreid"/>
        <label for="estado">Estado:</label>
        <input type="text" name="Estado"  id="estado" value="${programa.estado}"  />
        <br/>
        <label for="creadoPor">Creado Por:</label>
        <input type="text" name="Creado Por" id="creadoPor" value="${programa.creadopor}"/>
        <label for="creadoEn">Creado En :</label>
        <input type="text" name="Creado En" id="creadoEn" value="${programa.creadoen}"/>
        <br/>
        <label for="modificadoPor">Modificado Por:</label>
        <input type="text" name="Modificado Por" id="modificadoPor" value="${programa.modificadopor}"/>
        <label for="modificadoEn">Modificado En :</label>
        <input type="text" name="Modificado En" id="modificadoEn" value="${programa.modificadoen}"/>

        <br/>
         <input type="submit" id="nombredptid" value="Save"/>
       
    </f:form>
</body>
</html>
