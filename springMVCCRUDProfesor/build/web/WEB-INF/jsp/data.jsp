<%-- 
    Document   : data.jsp
    Created on : Sep 7, 2015, 10:58:53 AM
    Author     : DanielEduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTA DE DATOS</title>
    </head>
    <body>
        <a href="crear.html">Agregar</a>
        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Fecha Nacimiento</th>
                <th>Departamento</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${lst}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nombre}</td>
                    <td>${p.correo}</td>
                    <td>${p.telefono}</td>
                    <td>${p.direccion}</td>
                    <th>${p.nacimiento}</td>
                    <td>${p.departamento.id}</td>

                    
                    <td>
                        <a href="edit.html?id=${p.id}">
                            Edit </a>
                        <a href="remove.html?id=${p.id}" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>

        </table>





    </body>
</html>
