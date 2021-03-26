/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.entidade;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cliente {
    
    private String nome;
    private String email;
    private String cpf;
    
    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    
    public boolean validarCPF() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s <br/> Email: %s <br/> CPF: %s", nome, email, cpf);
    }
    
    
    
}
