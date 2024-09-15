package main.java.br.edu.ifpegus.condominio.domain.model;

public class Veiculo {
    private String placa;
    private String modelo;
    private Morador proprietario;
    private boolean autorizado;

    public Veiculo(String placa, String modelo, Morador proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.autorizado = false;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Morador getProprietario() {
        return proprietario;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void autorizarVeiculo() {
        this.autorizado = true;
    }

    public void desautorizarVeiculo() {
        this.autorizado = false;
    }
}
