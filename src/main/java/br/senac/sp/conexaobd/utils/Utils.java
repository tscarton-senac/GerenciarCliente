
package br.senac.sp.conexaobd.utils;

import br.senac.sp.conexaobd.entidade.Cliente;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Utils {
    
    public static void redirecionarURL(boolean ok, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/erro.jsp");
        }
    }
    
    public static Cliente popularCliente(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        String cpf = rs.getString("cpf");
        
        Cliente cliente = new Cliente(nome, email, cpf);
        return cliente;
    }
    
}
