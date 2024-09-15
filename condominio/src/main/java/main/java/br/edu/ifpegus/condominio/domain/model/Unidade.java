package main.java.br.edu.ifpegus.condominio.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import main.java.br.edu.ifpegus.condominio.domain.enums.TipoUnidade;
import main.java.br.edu.ifpegus.condominio.domain.model.ocorrencia.Ocorrencia;

@Entity
public class Unidade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private int numero;
	private TipoUnidade tipoUnidade;
	
	@OneToMany(mappedBy = "unidade")
    private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	private Morador morador;

	public Unidade(String nome, int numero, TipoUnidade tipoUnidade) {
		this.nome = nome;
		this.numero = numero;
		this.tipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numero, tipoUnidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		return Objects.equals(nome, other.nome) && numero == other.numero && tipoUnidade == other.tipoUnidade;
	}

	@Override
	public String toString() {
		return "Unidade [nome=" + nome + ", numero=" + numero + ", tipoUnidade=" + tipoUnidade + "]";
	}


	public void setInquilino(Morador morador) {
		this.morador = morador;
		
	}
	
	public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }
	
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencias.add(ocorrencia);
		
	}
}
