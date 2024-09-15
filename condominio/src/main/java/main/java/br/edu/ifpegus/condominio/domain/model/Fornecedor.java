package main.java.br.edu.ifpegus.condominio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String servico;

    public Fornecedor(String nome, String servico) {
        this.nome = nome;
        this.servico = servico;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }
    
    public void setServico(String servico) {
        this.servico = servico;
    }
}
