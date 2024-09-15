package test.java.br.edu.ifpegus.condominio.domain.documento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.enums.TipoDocumento;
import main.java.br.edu.ifpegus.condominio.domain.model.Condominio;
import main.java.br.edu.ifpegus.condominio.domain.model.Documento;

public class TesteRecuperacaoDocumentos {

    private Condominio condominio;

    @BeforeEach
    public void setUp() {
        condominio = new Condominio("Condominio ABC", 1500.0);
    }

    @Test
    public void deveRecuperarDocumentosPorTipo() {
        Documento ataReuniao = new Documento("Ata Reunião 01", "Discussões e decisões tomadas.", TipoDocumento.ATA_REUNIAO);
        Documento contrato = new Documento("Contrato de Prestação de Serviços", "Detalhes do contrato com o prestador.", TipoDocumento.CONTRATO);
        Documento regulamento = new Documento("Regulamento Interno", "Regras e regulamentos do condomínio.", TipoDocumento.REGULAMENTO_INTERNO);

        condominio.armazenarDocumento(ataReuniao);
        condominio.armazenarDocumento(contrato);
        condominio.armazenarDocumento(regulamento);

        List<Documento> atasReunioes = condominio.recuperarDocumentosPorTipo(TipoDocumento.ATA_REUNIAO);
        List<Documento> contratos = condominio.recuperarDocumentosPorTipo(TipoDocumento.CONTRATO);

        assertEquals(1, atasReunioes.size(), "Deve haver uma ata de reunião armazenada.");
        assertEquals(1, contratos.size(), "Deve haver um contrato armazenado.");

        assertTrue(atasReunioes.stream().anyMatch(doc -> doc.getTitulo().equals("Ata Reunião 01")), "A ata de reunião deve estar presente.");
        assertTrue(contratos.stream().anyMatch(doc -> doc.getTitulo().equals("Contrato de Prestação de Serviços")), "O contrato deve estar presente.");
    }
}
