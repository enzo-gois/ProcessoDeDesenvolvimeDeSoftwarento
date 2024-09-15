package test.java.br.edu.ifpegus.condominio.domain.veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.model.ControleAcessoVeiculo;
import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Veiculo;

public class ControleAcessoVeiculoTest {

    private ControleAcessoVeiculo controleAcesso;
    private Veiculo veiculo1;
    private Veiculo veiculo2;
    private Morador morador1;
    private Morador morador2;

    @BeforeEach
    public void setUp() {
        controleAcesso = new ControleAcessoVeiculo();
        morador1 = new Morador("João", "101");
        morador2 = new Morador("Maria", "202");

        veiculo1 = new Veiculo("ABC-1234", "Carro", morador1);
        veiculo2 = new Veiculo("XYZ-5678", "Moto", morador2);
    }

    @Test
    public void testCadastroVeiculoAutorizado() {
        controleAcesso.cadastrarVeiculo(veiculo1);

        assertTrue(veiculo1.isAutorizado(), "O veículo 1 deveria estar autorizado");
    }

    @Test
    public void testRegistroEntradaVeiculoAutorizado() {
        controleAcesso.cadastrarVeiculo(veiculo1);

        controleAcesso.registrarEntrada(veiculo1);

        assertFalse(controleAcesso.getRegistrosEntradaSaida().isEmpty(), "A lista de registros não deveria estar vazia");
        assertTrue(controleAcesso.getRegistrosEntradaSaida().get(0).contains("Entrada: ABC-1234"), "O registro deveria conter a entrada do veículo ABC-1234");
    }

    @Test
    public void testRegistroSaidaVeiculoAutorizado() {
        controleAcesso.cadastrarVeiculo(veiculo1);

        controleAcesso.registrarEntrada(veiculo1);
        controleAcesso.registrarSaida(veiculo1);

        assertTrue(controleAcesso.getRegistrosEntradaSaida().get(1).contains("Saída: ABC-1234"), "O registro deveria conter a saída do veículo ABC-1234");
    }

    @Test
    public void testRegistroEntradaVeiculoNaoAutorizado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controleAcesso.registrarEntrada(veiculo2);
        });

        assertEquals("Veículo não autorizado!", exception.getMessage());
    }
}
