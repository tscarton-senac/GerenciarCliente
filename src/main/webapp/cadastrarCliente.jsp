
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <c:import url="header.jsp"/>
        <form action="CadastroClienteServlet" method="POST">
            <p>Nome</p>
            <input type="text" name="nome" />
            <p>Email</p>
            <input type="text" name="email" />
            <p>CPF</p>
            <input type="text" name="cpf" />
            <br/><br/>
            <button type="submit" >Enviar</button>
        </form>
        
    </body>
</html>
