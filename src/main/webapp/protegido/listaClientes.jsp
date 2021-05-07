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
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <script>
            function confirmarExclusao(cpf) {
                console.log("Funfou!" , cpf);
                $("#cpfCliente").html(cpf);
                $(".modal").show();
            }
            
            function fecharModal(){
                $(".modal").hide();
            }
            
            function deletarCliente() {
                var cpfCliente = $("#cpfCliente").html();
                $(".modal").hide();
                //Chamada AJAX para o servlet
                $.ajax({
                    method: "GET",
                    url: "ExcluirCliente?cpf="+cpfCliente
                })
                .done(function( msg ) {
                   location.reload();
                });
                
                
            }
            
                
            
        </script>
        
        <h1>Lista de Clientes</h1>
        
        <table class="table">
            <thead>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
                <th></th>
                <th></th>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${listaClientes}" >
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td><a href="AlterarCliente?cpf=${cliente.cpf}" >Alterar</a></td>
                        <td><button type="button" class="btn btn-link" onclick="confirmarExclusao(${cliente.cpf})">Excluir</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="modal" tabindex="-1">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Confirmar Exclusão</h5>
                  <button type="button" class="btn-close"
                          data-bs-dismiss="modal" aria-label="Close" onclick="fecharModal()"></button>
                </div>
                <div class="modal-body">
                    <p>Confirmar a exclusão do cliente cpf <label id="cpfCliente"></label> ?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="fecharModal()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="deletarCliente()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        <br/>
        <c:import url="../footer.jsp"/>
    </body>
</html>
