package main.java.br.edu.ifpegus.condominio.domain.model.visitas;

import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Unidade;
import main.java.br.edu.ifpegus.condominio.domain.model.Usuario;

public class Visitante extends Usuario{
	
	private String data;
	private Unidade unidade;

	public Visitante(String nome, String data,Unidade unidade) {
		super(nome);
		this.data = data;
		this.unidade = unidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
    @Override
    public boolean fazerLogin(String nome) {
        return false;
    }
	
}
