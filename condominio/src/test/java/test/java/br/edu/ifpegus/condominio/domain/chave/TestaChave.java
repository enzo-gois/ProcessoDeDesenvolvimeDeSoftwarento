package test.java.br.edu.ifpegus.condominio.domain.chave;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoSetor;
import main.java.br.edu.ifpegus.condominio.domain.model.Administrador;
import main.java.br.edu.ifpegus.condominio.domain.model.Chave;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;

public class TestaChave {
    @Test
    public void deveRegistrarSaidaDeChave() {
        Condominio condominio = new Condominio("Condominio C", 3000.0);
        Administrador sindico = new Administrador("Ana", TipoSetor.SINDICO, condominio);
        Chave chave = new Chave("Chave do Salão de Festas");

        sindico.registrarSaidaChave(chave);
        assertFalse(chave.isDisponivel(), "A chave deve estar indisponível após registrar saída.");
    }

    @Test
    public void deveLancarExcecaoAoRegistrarSaidaSemPermissao() {
        Condominio condominio = new Condominio("Condominio D", 4000.0);
        Administrador porteiro = new Administrador("Carlos", TipoSetor.PORTEIRO, condominio);
        Chave chave = new Chave("Chave do Salão de Festas");

        assertThrows(IllegalArgumentException.class, () -> {
            porteiro.registrarSaidaChave(chave);
        }, "Deveria lançar exceção ao tentar registrar saída de chave sem permissão.");
    }

    @Test
    public void deveRegistrarDevolucaoDeChave() {
        Condominio condominio = new Condominio("Condominio E", 5000.0);
        Administrador conselheiro = new Administrador("Marcos", TipoSetor.CONSELHEIRO, condominio);
        Chave chave = new Chave("Chave do Salão de Festas");

        conselheiro.registrarSaidaChave(chave);
        conselheiro.registrarDevolucaoChave(chave);
        assertTrue(chave.isDisponivel(), "A chave deve estar disponível após registrar devolução.");
    }
}
