
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <c:if test="${not empty cliente}">
            <form action="AlterarCliente" method="POST">
                <p>Nome</p>
                <input type="text" name="nome" value="${cliente.nome}" class="form-control"/>
                <p>Email</p>
                <input type="text" name="email" value="${cliente.email}" class="form-control"/>
                <p>CPF</p>
                <input type="text" name="cpf" value="${cliente.cpf}" readonly="true" class="form-control"/>
                <br/><br/>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
            
        </c:if>
        <c:if test="${empty cliente}">
             <form action="CadastroClienteServlet" method="POST">
                 <div class="mb-3">
                     <p>Nome</p>
                <input type="text" name="nome" class="form-control" required="true"/>
                 </div>
                
                <p>Email</p>
                <input type="text" name="email" class="form-control" required="true"/>
                <p>CPF</p>
                <input type="text" name="cpf" class="form-control" required="true"/>
                <br/><br/>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
            
        </c:if>
        
        
       
        
    </body>
</html>
