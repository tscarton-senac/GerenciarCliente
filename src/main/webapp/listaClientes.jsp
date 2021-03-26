<%-- 
    Document   : listaClientes
    Created on : Mar 25, 2021, 9:36:19 PM
    Author     : t735915
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <c:import url="header.jsp"/>
        <h1>Lista de Clientes</h1>
        
        <table>
            <thead>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${listaClientes}" >
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <br/>
        <c:import url="footer.jsp"/>
    </body>
</html>
