
package br.senac.sp.conexaobd.dao;

import br.senac.sp.conexaobd.conexao.Conexao;
import br.senac.sp.conexaobd.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    
    public static Usuario getUsuario(String login, String senha) {
        Usuario usuario = null;
        try {
            Connection con = Conexao.getConexao();
            String query = "select * from usuario where login=? and senha=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setLogin(login);
                usuario.setFilial(rs.getString("filial"));
                usuario.setNome(rs.getString("nome"));
                usuario.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
        
        
    }
    
}
