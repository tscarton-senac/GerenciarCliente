/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Tiago Scarton
 */
@Getter
@Setter
public class Produto {

   private int id;
   private String nome;
   private Double preco;

    public Produto(int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'nome': '%s', 'preco': %f }", id, nome, preco);
    }
   
    
   
}
