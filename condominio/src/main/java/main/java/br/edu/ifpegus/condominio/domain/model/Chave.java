package main.java.br.edu.ifpegus.condominio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean disponivel;

    public Chave(String descricao) {
        this.descricao = descricao;
        this.disponivel = true;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void registrarSaida() {
        if (!disponivel) {
            throw new IllegalStateException("A chave já está em uso.");
        }
        this.disponivel = false;
    }

    public void registrarDevolucao() {
        this.disponivel = true;
    }
}
