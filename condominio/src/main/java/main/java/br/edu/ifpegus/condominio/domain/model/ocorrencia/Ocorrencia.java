package main.java.br.edu.ifpegus.condominio.domain.model.ocorrencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Unidade;

@Entity
public class Ocorrencia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String data;

    @ManyToOne
    private Morador morador;
    
    
    @ManyToOne
    @JoinColumn(name="unidade_id")
    private Unidade unidade;
    
    public Ocorrencia(Morador morador, String data, String descricao, Unidade unidade) {
    	this.morador = morador;
    	this.data = data;
    	this.descricao = descricao;
    	this.unidade = unidade;
    }

	public Long getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Morador getMorador() {
		return morador;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
    
    
}
