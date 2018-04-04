<%-- 
    Document   : programasView
    Created on : 6/02/2018, 12:39:19 PM
    Author     : luis.leon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <a href="crear.html">Agregar</a>
        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Estado</th>
                <th>CreadoPor</th>
                <th>Creadoen</th>
                <th>ModificadoPor</th>
                <th>ModificadoEn</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.idPrograma}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.estado}</td>
                    <td>${item.creadopor}</td>
                    <td>${item.creadoen}</td>
                    <td>${item.modificadopor}</td>
                    <td>${item.modificadoen}</td>
                    <td>
                        <a href="edit.html?id=${item.idPrograma}">
                            Edit 
                        </a>
                       <!-- 
                       <a href="remove.html?id=${item.idPrograma}" onclick="return confirm('Are you sure?')">Remove</a>
                        -->
                    </td>
                </tr>
            </c:forEach>

        </table>






    </body>
</html>
