package test.java.br.edu.ifpegus.condominio.domain.mensagem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.br.edu.ifpegus.condominio.domain.model.Mensagem;
import main.java.br.edu.ifpegus.condominio.domain.model.Morador;

public class MensagemTest {

    private Morador morador1;
    private Morador morador2;
    private Mensagem mensagem;

    @BeforeEach
    public void setUp() {
        morador1 = new Morador("João", "101");
        morador2 = new Morador("Maria", "202");
    }

    @Test
    public void testEnvioMensagemEntreMoradores() {
        mensagem = new Mensagem(morador1, morador2, "Assunto", "Conteúdo da mensagem");

        assertNotNull(mensagem, "A mensagem não deveria ser nula");
        assertEquals(morador1, mensagem.getRemetente(), "O remetente deveria ser João");
        assertEquals(morador2, mensagem.getDestinatario(), "O destinatário deveria ser Maria");
        assertEquals("Assunto", mensagem.getAssunto());
        assertEquals("Conteúdo da mensagem", mensagem.getConteudo());
    }

    @Test
    public void testEnvioMensagemSemDestinatario() {
        mensagem = new Mensagem(morador1, null, "Assunto", "Mensagem sem destinatário");

        assertNull(mensagem.getDestinatario(), "O destinatário deveria ser nulo");
    }

    @Test
    public void testEnvioMensagemComAssuntoVazio() {
        mensagem = new Mensagem(morador1, morador2, "", "Mensagem sem assunto");

        assertEquals("", mensagem.getAssunto(), "O assunto deveria estar vazio");
    }
}
