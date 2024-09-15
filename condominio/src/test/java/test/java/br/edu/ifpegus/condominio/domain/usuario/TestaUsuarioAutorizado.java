package test.java.br.edu.ifpegus.condominio.domain.usuario;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoSetor;
import main.java.br.edu.ifpegus.condominio.domain.enums.TipoUnidade;
import main.java.br.edu.ifpegus.condominio.domain.model.Administrador;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;
import main.java.br.edu.ifpegus.condominio.domain.model.visitas.Visitante;
import main.java.br.edu.ifpegus.condominio.domain.model.Unidade;

public class TestaUsuarioAutorizado {

    @Test
    public void devePermitirLoginParaAdministrador() {
        Condominio condominio = new Condominio("Condominio Central", 1500.00);
        Administrador administrador = new Administrador("Maria", TipoSetor.SINDICO, condominio);

        boolean loginValido = administrador.fazerLogin("Maria");

        assertTrue(loginValido, "O administrador deveria conseguir fazer login");
    }

    @Test
    public void deveBloquearLoginParaVisitante() {
        Unidade unidade = new Unidade("Bloco B", 202, TipoUnidade.APARTAMENTO);
        Visitante visitante = new Visitante("João Visitante", "2024-09-05", unidade);

        boolean loginValido = visitante.fazerLogin("João Visitante");

        assertFalse(loginValido, "Visitantes não deveriam conseguir fazer login");
    }
}
