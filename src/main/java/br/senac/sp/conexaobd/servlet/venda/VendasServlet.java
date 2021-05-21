/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.servlet.venda;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.entidade.Cliente;
import br.senac.sp.conexaobd.entidade.Produto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tiago Scarton
 */
public class VendasServlet extends HttpServlet {

    // Carregar a tela de vendas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Carregar Clientes
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        request.setAttribute("listaClientes", listaClientes);

        // Carregar produtos
        Produto produto1 = new Produto(1, "TV", 2000.0);
        Produto produto2 = new Produto(2, "Smartphone", 1500.0);
        Produto produto3 = new Produto(3, "Notebook", 3000.0);
        Produto produto4 = new Produto(4, "Headset", 500.0);

        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);
        listaProdutos.add(produto4);

        request.setAttribute("listaProdutos", listaProdutos);
        //Redirecionar para a tela de vendas
        request.getRequestDispatcher("/protegido/venda.jsp").forward(request, response);

    }

    // Fechar a venda!
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JSONObject vendaObj = this.getBody(request);
        Iterator<String> keys = vendaObj.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key);
        }
    }

    private JSONObject getBody(HttpServletRequest request) throws IOException {
        JSONObject jsonObject = null;
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            /*report an error*/ }

        try {
            jsonObject = HTTP.toJSONObject(jb.toString());
        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }
        return jsonObject;
    }
}
