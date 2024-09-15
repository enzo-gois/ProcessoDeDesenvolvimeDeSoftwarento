package main.java.br.edu.ifpegus.condominio.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import main.java.br.edu.ifpegus.condominio.domain.enums.TipoDocumento;
import main.java.br.edu.ifpegus.condominio.domain.model.ocorrencia.Ocorrencia;
import main.java.br.edu.ifpegus.condominio.domain.model.visitas.Visitante;

@Entity
public class Condominio {
	private static int id = 0;
	private String nome;
	private double valor;
	
	private List<Unidade> unidades = new ArrayList<>();
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	private List<Visitante> visitantes = new ArrayList<>();
	private List<Documento> documentos = new ArrayList<>();

	public Condominio(String nome, double valor) {
		this.id++;
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		return Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	@Override
	public String toString() {
		return "Condominio [nome=" + nome + ", valor=" + valor + "]";
	}
	
	
	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidade(Unidade unidade) {
		this.unidades.add(unidade);
		
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	public void registrarOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencias.add(ocorrencia);
		
	}
	
	public void registrarVisita(Visitante visita) {
		this.visitantes.add(visita);
	}


	public List<Visitante> getVisitantes() {
		return visitantes;
	}


	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}
	
    public void armazenarDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public Documento recuperarDocumentoPorTitulo(String titulo) {
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                return documento;
            }
        }
        return null;
    }

    public List<Documento> recuperarDocumentosPorTipo(TipoDocumento tipo) {
        return documentos.stream()
                .filter(documento -> documento.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }
	
}
