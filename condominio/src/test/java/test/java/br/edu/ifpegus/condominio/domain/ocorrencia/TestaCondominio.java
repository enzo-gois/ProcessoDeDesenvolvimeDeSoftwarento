package test.java.br.edu.ifpegus.condominio.domain.ocorrencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoUnidade;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;
import main.java.br.edu.ifpegus.condominio.domain.model.Morador;
import main.java.br.edu.ifpegus.condominio.domain.model.Unidade;
import main.java.br.edu.ifpegus.condominio.domain.model.ocorrencia.Ocorrencia;

public class TestaCondominio {
	
	@Test
    void testaRegistroDeOcorrenciaParaCondominio() {
        Condominio condominio = new Condominio("Condominio A", 1000.0);
        Morador morador = new Morador("João", "Apartamento 101");
        Unidade unidade = new Unidade("Apartamento 101", 101, TipoUnidade.CASA);
        Ocorrencia ocorrencia = new Ocorrencia(morador, "01/09/2024", "Queixa de barulho", unidade);

        condominio.registrarOcorrencia(ocorrencia);

        assertEquals(1, condominio.getOcorrencias().size());
        assertEquals("Queixa de barulho", condominio.getOcorrencias().get(0).getDescricao());
    }
}
