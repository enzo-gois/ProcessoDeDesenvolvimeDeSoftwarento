package main.java.br.edu.ifpegus.condominio.domain.model;

import jakarta.persistence.Entity;
import main.java.br.edu.ifpegus.condominio.domain.enums.TipoSetor;
import main.java.br.edu.ifpegus.condominio.domain.model.visitas.Visitante;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Administrador extends Usuario{
	
	private TipoSetor tipoSetor;
	private Condominio condominio;
	
	public Administrador(String nome, TipoSetor tipoSetor, Condominio condominio) {
        super(nome);
        this.tipoSetor = tipoSetor;
        this.condominio = condominio; 
    }

	public TipoSetor getSetor() {
		return tipoSetor;
	}

	public void setSetor(TipoSetor tipoSetor) {
		this.tipoSetor = tipoSetor;
	}
	
	
	public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public void registrarVisita(Visitante visita) {
        if (this.tipoSetor != TipoSetor.PORTEIRO) {
            throw new IllegalArgumentException("Apenas administradores do tipo PORTEIRO podem registrar visitas.");
        }

        this.condominio.registrarVisita(visita);
        System.out.println("Visitante " + visita.getNome() + " registrado com sucesso.");
    }
    
    public void registrarSaidaChave(Chave chave) {
        if (this.tipoSetor != TipoSetor.SINDICO && this.tipoSetor != TipoSetor.CONSELHEIRO) {
            throw new IllegalArgumentException("Apenas administradores do tipo SINDICO ou CONSELHEIRO podem registrar a saída de chaves.");
        }
        chave.registrarSaida();
    }

    public void registrarDevolucaoChave(Chave chave) {
        if (this.tipoSetor != TipoSetor.SINDICO && this.tipoSetor != TipoSetor.CONSELHEIRO) {
            throw new IllegalArgumentException("Apenas administradores do tipo SINDICO ou CONSELHEIRO podem registrar a devolução de chaves.");
        }
        chave.registrarDevolucao();
    }
    
    private List<Fornecedor> fornecedores = new ArrayList<>();
    
    public void cadastrarFornecedor(Fornecedor fornecedor) {
        if (this.tipoSetor != TipoSetor.SINDICO && this.tipoSetor != TipoSetor.CONSELHEIRO) {
            throw new IllegalArgumentException("Apenas administradores do tipo SINDICO ou CONSELHEIRO podem cadastrar fornecedores.");
        }
        fornecedores.add(fornecedor);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
    
    @Override
    public boolean fazerLogin(String nome) {
        return super.fazerLogin(nome);
    }
}
