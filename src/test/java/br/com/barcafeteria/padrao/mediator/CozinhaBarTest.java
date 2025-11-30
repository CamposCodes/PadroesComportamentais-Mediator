package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CozinhaBarTest {

    private CozinhaBar cozinhaBar;

    @BeforeEach
    void setUp() {
        cozinhaBar = CozinhaBar.getInstancia();
        Bar.getInstancia().setDisponivel(true);
        Cozinha.getInstancia().setDisponivel(true);
        Barista.getInstancia().setDisponivel(true);
    }

    @Test
    void deveSerSingleton() {
        CozinhaBar cozinhaBar1 = CozinhaBar.getInstancia();
        CozinhaBar cozinhaBar2 = CozinhaBar.getInstancia();

        assertSame(cozinhaBar1, cozinhaBar2);
    }

    @Test
    void deveReceberPedidoBebidaAlcoolica() {
        String resultado = cozinhaBar.receberPedidoBebidaAlcoolica("Chopp gelado");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Bar"));
        assertTrue(resultado.contains("bebida alcoólica"));
        assertTrue(resultado.contains("Chopp gelado"));
    }

    @Test
    void deveReceberPedidoAlimento() {
        String resultado = cozinhaBar.receberPedidoAlimento("Pizza margherita");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(resultado.contains("alimento"));
        assertTrue(resultado.contains("Pizza margherita"));
    }

    @Test
    void deveReceberPedidoBebistaEspecial() {
        String resultado = cozinhaBar.receberPedidoBebistaEspecial("Café coado com leite quente");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Barista"));
        assertTrue(resultado.contains("bebida especial"));
        assertTrue(resultado.contains("Café coado com leite quente"));
    }

    @Test
    void deveVerificarDisponibilidadeSetores() {
        String status = cozinhaBar.verificarDisponibilidadeSetores();

        assertNotNull(status);
        assertTrue(status.contains("Status dos Setores"));
        assertTrue(status.contains("Bar: Disponível"));
        assertTrue(status.contains("Cozinha: Disponível"));
        assertTrue(status.contains("Barista: Disponível"));
    }

    @Test
    void deveVerificarIndisponibilidadeSetores() {
        Bar.getInstancia().setDisponivel(false);
        Cozinha.getInstancia().setDisponivel(false);

        String status = cozinhaBar.verificarDisponibilidadeSetores();

        assertTrue(status.contains("Bar: Ocupado"));
        assertTrue(status.contains("Cozinha: Ocupada"));
    }

    @Test
    void deveObterhTemposEstimados() {
        String tempos = cozinhaBar.obterTemposEstimados();

        assertNotNull(tempos);
        assertTrue(tempos.contains("Tempos Estimados de Preparo"));
        assertTrue(tempos.contains("minutos"));
        assertTrue(tempos.contains("Bar:"));
        assertTrue(tempos.contains("Cozinha:"));
        assertTrue(tempos.contains("Barista:"));
    }

    @Test
    void deveConterFormatacaoCorretaBebidaAlcoolica() {
        String resultado = cozinhaBar.receberPedidoBebidaAlcoolica("Vinho");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }

    @Test
    void deveConterFormatacaoCorretaAlimento() {
        String resultado = cozinhaBar.receberPedidoAlimento("Sushi");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }

    @Test
    void deveConterFormatacaoCorretaBebistaEspecial() {
        String resultado = cozinhaBar.receberPedidoBebistaEspecial("Chá");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }
}
