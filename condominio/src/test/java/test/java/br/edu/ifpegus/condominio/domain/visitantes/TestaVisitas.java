package test.java.br.edu.ifpegus.condominio.domain.visitantes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoSetor;
import main.java.br.edu.ifpegus.condominio.domain.enums.TipoUnidade;
import main.java.br.edu.ifpegus.condominio.domain.model.Administrador;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;
import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Unidade;
import main.java.br.edu.ifpegus.condominio.domain.model.visitas.Visitante;

public class TestaVisitas {
	
	@Test
	public void deveRegistrarVisitanteNoCondominio() {
		Condominio condominio = new Condominio("Condominio A", 1000.0);
		Administrador porteiro = new Administrador("Carlos", TipoSetor.PORTEIRO, condominio);
        Unidade unidade = new Unidade("Bloco B", 202, TipoUnidade.APARTAMENTO);
        Visitante visitante = new Visitante("João Silva","2023-09-07", unidade);
        
        porteiro.registrarVisita(visitante);

        assertEquals(1, condominio.getVisitantes().size(), "Deveria haver um visitante registrado");
    }
	
	@Test
    public void deveLancarExcecaoQuandoNaoForPorteiro() {
        Condominio condominio = new Condominio("Condominio B", 2000.0);
        Administrador sindico = new Administrador("Joana", TipoSetor.SINDICO, condominio);
        Unidade unidade = new Unidade("Bloco C", 303, TipoUnidade.APARTAMENTO);
        Visitante visitante = new Visitante("Maria Silva", "2023-09-07", unidade);

        assertThrows(IllegalArgumentException.class, () -> {
            sindico.registrarVisita(visitante);
        }, "Deveria lançar uma exceção ao tentar registrar visita com um administrador que não é PORTEIRO");
    }
	
	
}
