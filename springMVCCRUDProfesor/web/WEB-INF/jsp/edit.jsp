<%-- 
    Document   : edit
    Created on : Sep 7, 2015, 11:30:59 AM
    Author     : DanielEduardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT</title>
    </head>
    <body>

        <f:form action="update.html" modelAttribute="Profesor">
            <input type="hidden" name="id" value="${p.id}"/>
            <label for="nombreid">Nombre :</label>
            <input type="text" name="nombre" value="${p.nombre}" id="nombreid"/>
            <label for="emailid">Correo:</label>
            <input type="email" name="correo"  id="emailid"value="${p.correo}" />
            <br/>
            <label for="telefonoid">Telefono:</label>
            <input type="text" name="telefono" id="telefonoid" value="${p.telefono}"/>
            <label for="direccionid">Direccion:</label>

            <input type="text" name="direccion" id="direccion" value="${p.direccion}"/>
                        <br/>

             <label for="nacimientoid">Fecha de Nacimiento</label>

           <input type="text" name ="nacimiento" id="nacimientoid"value="${p.nacimiento}"/>
            <br/>
             <br/>
  
           <label for="departementoid">Codigo departamento</label>

            <input  type="text" name="depatemento.id" id="departementoid" value="${p.departamento.id}"/>
            <label for="nombredtpid" >Nombre DPT:${d.nombre}</label>
                         <br/>

            <input type="submit" id="nombredptid" value="Save"/>
        </f:form>
            

    </body>
</html>

