package test.java.br.edu.ifpegus.condominio.domain.reserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.reserva.EspacoComum;
import main.java.br.edu.ifpegus.condominio.domain.model.reserva.Reserva;

public class TestaReservaEspaco {
	
	@Test
    public void devePermitirMoradorReservarEspacoComum() {
        Morador morador = new Morador("João", "Apartamento 05");
        EspacoComum salaFestas = new EspacoComum("Sala de Festas");

        salaFestas.reservar();
        Reserva reserva = new Reserva(morador, salaFestas);
        morador.adicionarReserva(reserva);

        assertEquals(1, morador.getReservas().size(), "Deveria haver uma reserva registrada para o morador.");
        assertEquals(false, salaFestas.isDisponivel(), "O espaço deve estar indisponível após a reserva.");
    }

    @Test
    public void naoDevePermitirReservaDeEspacoIndisponivel() {
        Morador morador1 = new Morador("João", "Apartamento 199");
        Morador morador2 = new Morador("Maria", "Apartamento 203");
        EspacoComum piscina = new EspacoComum("Piscina");

        piscina.reservar();
        Reserva reserva1 = new Reserva(morador1, piscina);
        morador1.adicionarReserva(reserva1);

        assertThrows(IllegalStateException.class, () -> {
            piscina.reservar();
        }, "Deveria lançar exceção ao tentar reservar um espaço já reservado.");
    }
}
