package main.java.br.edu.ifpegus.condominio.domain.model;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoDocumento;

public class Documento {

    private String titulo;
    private String conteudo;
    private TipoDocumento tipo;

    public Documento(String titulo, String conteudo, TipoDocumento tipo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
}
