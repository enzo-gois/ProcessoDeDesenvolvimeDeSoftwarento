package main.java.br.edu.ifpegus.condominio.domain.model.reserva;

import main.java.br.edu.ifpegus.condominio.domain.model.Morador;

public class Reserva {
	
	private Morador morador;
    private EspacoComum espacoComum;

    public Reserva(Morador morador, EspacoComum espacoComum) {
        this.morador = morador;
        this.espacoComum = espacoComum;
    }

    public Morador getMorador() {
        return morador;
    }

    public EspacoComum getEspacoComum() {
        return espacoComum;
    }
}
