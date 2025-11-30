package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    private Bar bar;

    @BeforeEach
    void setUp() {
        bar = Bar.getInstancia();
        bar.setDisponivel(true);
        bar.setTempoEstimado(3);
    }

    @Test
    void deveSerSingleton() {
        Bar bar1 = Bar.getInstancia();
        Bar bar2 = Bar.getInstancia();

        assertSame(bar1, bar2);
    }

    @Test
    void deveReceberPedido() {
        String resultado = bar.receberPedido("Mojito");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Bar"));
        assertTrue(resultado.contains("bebida alcoólica"));
        assertTrue(resultado.contains("Mojito"));
    }

    @Test
    void deveImplementarSetorPreparo() {
        assertTrue(bar instanceof SetorPreparo);
    }

    @Test
    void deveEstarDisponivel() {
        bar.setDisponivel(true);
        assertTrue(bar.estaDisponivel());
    }

    @Test
    void deveNaoEstarDisponivel() {
        bar.setDisponivel(false);
        assertFalse(bar.estaDisponivel());
    }

    @Test
    void deveObterhTempoEstimado() {
        bar.setTempoEstimado(5);
        assertEquals(5, bar.obterTempoEstimado());
    }

    @Test
    void deveAlterarTempoEstimado() {
        int tempoInicial = bar.obterTempoEstimado();
        bar.setTempoEstimado(10);

        assertNotEquals(tempoInicial, bar.obterTempoEstimado());
        assertEquals(10, bar.obterTempoEstimado());
    }
}
