package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CozinhaTest {

    private Cozinha cozinha;

    @BeforeEach
    void setUp() {
        cozinha = Cozinha.getInstancia();
        cozinha.setDisponivel(true);
        cozinha.setTempoEstimado(15);
    }

    @Test
    void deveSerSingleton() {
        Cozinha cozinha1 = Cozinha.getInstancia();
        Cozinha cozinha2 = Cozinha.getInstancia();

        assertSame(cozinha1, cozinha2);
    }

    @Test
    void deveReceberPedido() {
        String resultado = cozinha.receberPedido("Frango à Parmegiana");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(resultado.contains("alimento"));
        assertTrue(resultado.contains("Frango à Parmegiana"));
    }

    @Test
    void deveImplementarSetorPreparo() {
        assertTrue(cozinha instanceof SetorPreparo);
    }

    @Test
    void deveEstarDisponivel() {
        cozinha.setDisponivel(true);
        assertTrue(cozinha.estaDisponivel());
    }

    @Test
    void deveNaoEstarDisponivel() {
        cozinha.setDisponivel(false);
        assertFalse(cozinha.estaDisponivel());
    }

    @Test
    void deveObterhTempoEstimado() {
        cozinha.setTempoEstimado(20);
        assertEquals(20, cozinha.obterTempoEstimado());
    }

    @Test
    void deveAlterarTempoEstimado() {
        int tempoInicial = cozinha.obterTempoEstimado();
        cozinha.setTempoEstimado(25);

        assertNotEquals(tempoInicial, cozinha.obterTempoEstimado());
        assertEquals(25, cozinha.obterTempoEstimado());
    }
}
