package main.java.br.edu.ifpegus.condominio.domain.model;

import java.time.LocalDateTime;

public class Mensagem {
    
    private Morador remetente;
    private Morador destinatario;
    private String assunto;
    private String conteudo;
    private LocalDateTime dataEnvio;

    public Mensagem(Morador remetente, Morador destinatario, String assunto, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
        this.dataEnvio = LocalDateTime.now();
    }

    public Morador getRemetente() {
        return remetente;
    }

    public Morador getDestinatario() {
        return destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }
}
