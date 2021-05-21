<%-- 
    Document   : venda
    Created on : May 20, 2021, 7:28:38 PM
    Author     : Tiago Scarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        <script>
            
            var produtosCarrinho = {};
            var clienteSelecionado = null;
            
            function selecionarCliente() {
                clienteSelecionado = $("#clienteSelect").val();
            }
            
            function addProduto(produto) {
                produto = produto.replaceAll("'", "\"");
                var produto = JSON.parse(produto);
                
                if (produtosCarrinho[produto.id] == null) {
                    produto.qte = 1;
                    produtosCarrinho[produto.id] = produto;
                } else {
                    produtosCarrinho[produto.id].qte++;
                }
                console.log(produtosCarrinho);
               $('#carrinho tbody').empty();
               var totalCompra = 0;
                for(index in produtosCarrinho) {
                    var produtoCarrinho = produtosCarrinho[index];
                    var markup = "<tr><td>"+produtoCarrinho.id+"</td><td>" + produtoCarrinho.nome +
                            "</td><td>" + produtoCarrinho.preco + "</td><td>" + produtoCarrinho.qte + "</td></tr>";
                    totalCompra += (produtoCarrinho.preco * produtoCarrinho.qte);
                    $("#carrinho tbody").append(markup);
                }
                $("#total").html(totalCompra);
                
            }
            
            function fecharCompra() {
                console.log("Produtos escolhidos ", produtosCarrinho);
                console.log("Cliente ", clienteSelecionado);
                var produtos = [];
                for(index in produtosCarrinho) {
                    var produtoCarrinho = produtosCarrinho[index];
                    produtos.push(produtoCarrinho);
                }
                var postValue = { produtos: produtos, cliente: clienteSelecionado };
                console.log("postValue ", postValue);
                $.post( "VendasServlet", JSON.stringify(postValue))
                .done(function( data ) {
                  alert( "Venda Realizada");
                });
                
                
            }
        </script>
        <h2>Escolha o Cliente</h2>
        <select name="clienteSelect" id="clienteSelect" class="form-select mb-3" style="width:auto;" onchange="selecionarCliente()">
            <option value="">Selecione o cliente</option>
            <c:forEach items="${listaClientes}" var="cliente">
                <option value="${cliente.id}">${cliente.nome}</option>
            </c:forEach>
        </select>
        
        <h2>Lista de Produtos</h2>
        <table class="table">
            <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Preço</th>
            </thead>
            <tbody>
                <c:forEach items="${listaProdutos}" var="produto">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.preco}</td>
                        <td><button type="button" class="btn btn-primary" onclick="addProduto(`${produto}`)">Add</button></td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>`
        
        <h2>Carrinho</h2>
        <table class="table" id="carrinho">
            <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Preço</th>
                <th>Quantidade</th>
            </thead>
            <tbody>
                
            </tbody>
            
        </table>
        <h3>Total do Carrinho R$ <label id="total">0,00</label></h3>
        <button type="button" class="btn btn-primary" onclick="fecharCompra()">Fechar Compra</button><br/><br/>
        <c:import url="../footer.jsp"/>
    </body>
</html>
