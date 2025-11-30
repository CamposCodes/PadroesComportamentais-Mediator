package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BaristaTest {

    private Barista barista;

    @BeforeEach
    void setUp() {
        barista = Barista.getInstancia();
        barista.setDisponivel(true);
        barista.setTempoEstimado(5);
    }

    @Test
    void deveSerSingleton() {
        Barista barista1 = Barista.getInstancia();
        Barista barista2 = Barista.getInstancia();

        assertSame(barista1, barista2);
    }

    @Test
    void deveReceberPedido() {
        String resultado = barista.receberPedido("Latte com xarope de baunilha");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Barista"));
        assertTrue(resultado.contains("bebida especial"));
        assertTrue(resultado.contains("Latte com xarope de baunilha"));
    }

    @Test
    void deveImplementarSetorPreparo() {
        assertTrue(barista instanceof SetorPreparo);
    }

    @Test
    void deveEstarDisponivel() {
        barista.setDisponivel(true);
        assertTrue(barista.estaDisponivel());
    }

    @Test
    void deveNaoEstarDisponivel() {
        barista.setDisponivel(false);
        assertFalse(barista.estaDisponivel());
    }

    @Test
    void deveObterhTempoEstimado() {
        barista.setTempoEstimado(7);
        assertEquals(7, barista.obterTempoEstimado());
    }

    @Test
    void deveAlterarTempoEstimado() {
        int tempoInicial = barista.obterTempoEstimado();
        barista.setTempoEstimado(10);

        assertNotEquals(tempoInicial, barista.obterTempoEstimado());
        assertEquals(10, barista.obterTempoEstimado());
    }
}
