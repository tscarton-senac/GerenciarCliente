

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        <p>Usuário Logado: ${sessionScope.usuario.nome} | ${sessionScope.usuario.filial}</p>
        
        <a href="cadastrarCliente.jsp">Cadastrar Cliente</a><br/>
        <a href="ClienteServlet">Listar Clientes</a><br/>
        <a href="<c:url value="/VendasServlet"/>">Realizar Venda</a><br/>
        
        <c:if test="${sessionScope.usuario.isGerente()}">
            <a href="gerente/relatorio.jsp">Relatório</a>
        </c:if>
        
    </body>
</html>
