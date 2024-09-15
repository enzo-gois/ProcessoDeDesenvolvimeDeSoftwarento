package main.java.br.edu.ifpegus.condominio.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import main.java.br.edu.ifpegus.condominio.domain.model.reserva.Reserva;

@Entity
public class Morador extends Usuario{
	
	private String apartamento;
	private List<Reserva> reservas;
	
	public Morador(String nome, String apartamento) {
		super(nome);
		this.apartamento = apartamento;
		this.reservas = new ArrayList<>();
	}
	
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	
	public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
	
    private List<Pagamento> pagamentos = new ArrayList<>();
    
    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public List<Pagamento> getHistoricoPagamentos() {
        return pagamentos;
    }
}
