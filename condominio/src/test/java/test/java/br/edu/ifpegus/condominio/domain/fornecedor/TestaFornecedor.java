package test.java.br.edu.ifpegus.condominio.domain.fornecedor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoSetor;
import main.java.br.edu.ifpegus.condominio.domain.model.Administrador;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;
import main.java.br.edu.ifpegus.condominio.domain.model.Fornecedor;

public class TestaFornecedor {
    
    @Test
    public void deveCadastrarFornecedor() {
        Condominio condominio = new Condominio("Condominio F", 6000.0);
        Administrador sindico = new Administrador("Lucia", TipoSetor.SINDICO, condominio);
        Fornecedor fornecedor = new Fornecedor("Limpeza S/A", "Limpeza");

        sindico.cadastrarFornecedor(fornecedor);
        assertEquals(1, sindico.getFornecedores().size(), "Deveria haver um fornecedor cadastrado.");
        assertEquals("Limpeza S/A", sindico.getFornecedores().get(0).getNome(), "O nome do fornecedor deve ser 'Limpeza S/A'.");
        assertEquals("Limpeza", sindico.getFornecedores().get(0).getServico(), "O serviço do fornecedor deve ser 'Limpeza'.");
    }

    @Test
    public void deveLancarExcecaoAoCadastrarFornecedorSemPermissao() {
        Condominio condominio = new Condominio("Condominio G", 7000.0);
        Administrador porteiro = new Administrador("Pedro", TipoSetor.PORTEIRO, condominio);
        Fornecedor fornecedor = new Fornecedor("Segurança Ltda", "Segurança");

        assertThrows(IllegalArgumentException.class, () -> {
            porteiro.cadastrarFornecedor(fornecedor);
        }, "Deveria lançar exceção ao tentar cadastrar fornecedor sem permissão.");
    }

    @Test
    public void deveAtualizarInformacoesDoFornecedor() {
        Condominio condominio = new Condominio("Condominio H", 8000.0);
        Administrador sindico = new Administrador("Marina", TipoSetor.SINDICO, condominio);
        Fornecedor fornecedor = new Fornecedor("Manutenção XYZ", "Manutenção Predial");

        sindico.cadastrarFornecedor(fornecedor);
        fornecedor.setNome("Manutenção ABC");
        fornecedor.setServico("Manutenção Elétrica");

        assertEquals(1, sindico.getFornecedores().size(), "Deveria haver um fornecedor cadastrado.");
        assertEquals("Manutenção ABC", sindico.getFornecedores().get(0).getNome(), "O nome do fornecedor deve ser 'Manutenção ABC'.");
        assertEquals("Manutenção Elétrica", sindico.getFornecedores().get(0).getServico(), "O serviço do fornecedor deve ser 'Manutenção Elétrica'.");
    }
}
