package main.java.br.edu.ifpegus.condominio.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControleAcessoVeiculo {

    private List<Veiculo> veiculosAutorizados;
    private List<String> registrosEntradaSaida;

    public ControleAcessoVeiculo() {
        this.veiculosAutorizados = new ArrayList<>();
        this.registrosEntradaSaida = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculosAutorizados.add(veiculo);
        veiculo.autorizarVeiculo();
    }

    public void registrarEntrada(Veiculo veiculo) {
        if (veiculo.isAutorizado()) {
            String registro = "Entrada: " + veiculo.getPlaca() + " às " + LocalDateTime.now();
            registrosEntradaSaida.add(registro);
        } else {
            throw new IllegalArgumentException("Veículo não autorizado!");
        }
    }

    public void registrarSaida(Veiculo veiculo) {
        if (veiculo.isAutorizado()) {
            String registro = "Saída: " + veiculo.getPlaca() + " às " + LocalDateTime.now();
            registrosEntradaSaida.add(registro);
        } else {
            throw new IllegalArgumentException("Veículo não autorizado!");
        }
    }

    public List<String> getRegistrosEntradaSaida() {
        return registrosEntradaSaida;
    }

    public boolean isVeiculoAutorizado(String placa) {
        return veiculosAutorizados.stream()
                                  .anyMatch(veiculo -> veiculo.getPlaca().equals(placa) && veiculo.isAutorizado());
    }
}
