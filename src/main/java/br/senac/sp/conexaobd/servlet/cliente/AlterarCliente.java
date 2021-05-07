
package br.senac.sp.conexaobd.servlet.cliente;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.entidade.Cliente;
import br.senac.sp.conexaobd.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlterarCliente extends HttpServlet {

    // Recuperar o cliente e direcionar para tela de atualização
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        
        request.setAttribute("cliente", cliente);
        
         request.getRequestDispatcher("/protegido/cadastrarCliente.jsp").forward(request, response);
        
        
    }

    // Atualizar o BD e direcionar para tela de sucesso
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String cpf = request.getParameter("cpf");
         String nome = request.getParameter("nome");
         String email = request.getParameter("email");
         
         Cliente cliente = new Cliente(nome, email, cpf);
         boolean ok = ClienteDAO.atualizarCliente(cliente);
         Utils.redirecionarURL(ok, request, response);
    }

    

}
