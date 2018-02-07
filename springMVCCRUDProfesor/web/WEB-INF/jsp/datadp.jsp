<%-- 
    Document   : datadp
    Created on : Sep 11, 2015, 12:19:01 AM
    Author     : DanielEduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lISTA DE DATOS</title>
    </head>
    <body>
       <a href="creardp.html">Agregar</a>
        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                
            </tr>

            <c:forEach items="${lst}" var="dp">
                <tr>
                    <td>${dp.id}</td>
                    <td>${dp.nombre}</td>
                 
                    <td>
                        <a href="editdp.html?id=${dp.id}">
                            Edit </a>
                        <a href="removedp.html?id=${dp.id}" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>

        </table>


    </body>
</html>
