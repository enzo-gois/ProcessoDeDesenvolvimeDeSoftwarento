package main.java.br.edu.ifpegus.condominio.domain.model.reserva;

public class EspacoComum {
	
	private String nome;
    private boolean disponivel;

    public EspacoComum(String nome) {
        this.nome = nome;
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        if (!disponivel) {
            throw new IllegalStateException("O espaço já está reservado.");
        }
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }
}
