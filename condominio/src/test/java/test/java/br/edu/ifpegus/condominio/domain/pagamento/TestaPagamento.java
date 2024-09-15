package test.java.br.edu.ifpegus.condominio.domain.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Pagamento;

public class TestaPagamento {
    @Test
    public void deveVisualizarHistoricoDePagamentos() {
        Morador morador = new Morador("João", "Apartamento 05");
        Pagamento pagamento1 = new Pagamento("Condomínio Janeiro", 500.0, "01/01/2024");
        Pagamento pagamento2 = new Pagamento("Condomínio Fevereiro", 500.0, "01/02/2024");

        morador.adicionarPagamento(pagamento1);
        morador.adicionarPagamento(pagamento2);

        assertEquals(2, morador.getHistoricoPagamentos().size(), "Deveria haver dois pagamentos no histórico.");
        assertEquals("Condomínio Janeiro", morador.getHistoricoPagamentos().get(0).getDescricao(), "A descrição do primeiro pagamento deve ser 'Condomínio Janeiro'.");
    }
}
