/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.dao;

import br.senac.sp.conexaobd.conexao.Conexao;
import br.senac.sp.conexaobd.entidade.Cliente;
import br.senac.sp.conexaobd.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scarton
 */
public class ClienteDAO {
    
    
    public static boolean cadastrarCliente(Cliente cliente) {
        boolean ok = true;
        try {
            Connection con = Conexao.getConexao();
            String query = "insert into cliente(nome, email, cpf) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
   public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                Integer id = rs.getInt("id");
                Cliente cliente = new Cliente(nome, email, cpf);
                cliente.setId(id);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
        
        
        
    }
   
   public static boolean excluirCliente(String cpf) {
       boolean ok = true;
       String query = "delete from cliente where cpf=?";
       Connection conn;
        try {
            conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
   
   public static Cliente getCliente(String cpf) {
       Cliente cliente = null;
       String query = "select * from cliente where cpf=?";
       Connection conn;
        try {
            conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = Utils.popularCliente(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
   }
   
   public static boolean atualizarCliente(Cliente cliente) {
       boolean ok = true;
       String query = "update cliente set nome=?,email=? where cpf=?";
       Connection conn;
        try {
            conn = Conexao.getConexao();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
    
}
