
package br.senac.sp.conexaobd.servlet.cliente;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirCliente extends HttpServlet {

   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        boolean ok = ClienteDAO.excluirCliente(cpf);
        Utils.redirecionarURL(ok, response);
    }


}
