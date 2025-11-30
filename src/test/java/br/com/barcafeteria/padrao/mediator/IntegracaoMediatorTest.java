package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class IntegracaoMediatorTest {

    private Garcom garcom;

    @BeforeEach
    void setUp() {
        garcom = new Garcom();
        Bar.getInstancia().setDisponivel(true);
        Cozinha.getInstancia().setDisponivel(true);
        Barista.getInstancia().setDisponivel(true);
    }

    @Test
    void deveFluxoCompletoPedidoBebidaAlcoolica() {
        String resultado = garcom.solicitarBebidaAlcoolica("Caipirinha com limão");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Bar"));
        assertTrue(resultado.contains("bebida alcoólica"));
        assertTrue(resultado.contains("Caipirinha com limão"));
    }

    @Test
    void deveFluxoCompletoPedidoAlimento() {
        String resultado = garcom.solicitarAlimento("Costela ao molho");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(resultado.contains("alimento"));
        assertTrue(resultado.contains("Costela ao molho"));
    }

    @Test
    void deveFluxoCompletoPedidoBebistaEspecial() {
        String resultado = garcom.solicitarBebistaEspecial("Capuccino com canela");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Barista"));
        assertTrue(resultado.contains("bebida especial"));
        assertTrue(resultado.contains("Capuccino com canela"));
    }

    @Test
    void deveMultiplosPedidosSimultaneos() {
        String pedido1 = garcom.solicitarBebidaAlcoolica("Cerveja");
        String pedido2 = garcom.solicitarAlimento("Fritas");
        String pedido3 = garcom.solicitarBebistaEspecial("Café");

        assertNotNull(pedido1);
        assertNotNull(pedido2);
        assertNotNull(pedido3);

        assertTrue(pedido1.contains("Bar"));
        assertTrue(pedido2.contains("Cozinha"));
        assertTrue(pedido3.contains("Barista"));
    }

    @Test
    void deveMediadorRotearParaSetorCorreto() {
        String pedidoAlcoolica = garcom.solicitarBebidaAlcoolica("Vodka");
        String pedidoAlimento = garcom.solicitarAlimento("Bife");
        String pedidoBebistaEspecial = garcom.solicitarBebistaEspecial("Macchiato");

        assertTrue(pedidoAlcoolica.contains("Bar"));
        assertTrue(pedidoAlimento.contains("Cozinha"));
        assertTrue(pedidoBebistaEspecial.contains("Barista"));
    }

    @Test
    void deveSingletonsManterEstado() {
        Bar.getInstancia().setTempoEstimado(8);
        Cozinha.getInstancia().setTempoEstimado(25);
        Barista.getInstancia().setTempoEstimado(6);

        assertEquals(8, Bar.getInstancia().obterTempoEstimado());
        assertEquals(25, Cozinha.getInstancia().obterTempoEstimado());
        assertEquals(6, Barista.getInstancia().obterTempoEstimado());
    }

    @Test
    void deveMediadorCentralizarComunicacao() {
        CozinhaBar mediador = CozinhaBar.getInstancia();

        String pedido1 = mediador.receberPedidoBebidaAlcoolica("Gin Tônica");
        String pedido2 = mediador.receberPedidoAlimento("Salmão grelhado");
        String pedido3 = mediador.receberPedidoBebistaEspecial("Café com leite");

        assertTrue(pedido1.contains(">>"));
        assertTrue(pedido2.contains(">>"));
        assertTrue(pedido3.contains(">>"));
    }
}
