package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario();
    }

    @Test
    void deveSolicitarBebidaAlcoolica() {
        String resultado = funcionario.solicitarBebidaAlcoolica("Cerveja gelada");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Bar"));
        assertTrue(resultado.contains("bebida alcoólica"));
        assertTrue(resultado.contains("Cerveja gelada"));
    }

    @Test
    void deveSolicitarAlimento() {
        String resultado = funcionario.solicitarAlimento("Batata frita");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(resultado.contains("alimento"));
        assertTrue(resultado.contains("Batata frita"));
    }

    @Test
    void deveSolicitarBebistaEspecial() {
        String resultado = funcionario.solicitarBebistaEspecial("Cappuccino com canela");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha/Bar recebeu o pedido"));
        assertTrue(resultado.contains("Barista"));
        assertTrue(resultado.contains("bebida especial"));
        assertTrue(resultado.contains("Cappuccino com canela"));
    }

    @Test
    void deveConterFormatacaoCorretaBebidaAlcoolica() {
        String resultado = funcionario.solicitarBebidaAlcoolica("Vinho tinto");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }

    @Test
    void deveConterFormatacaoCorretaAlimento() {
        String resultado = funcionario.solicitarAlimento("Hambúrguer");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }

    @Test
    void deveConterFormatacaoCorretaBebistaEspecial() {
        String resultado = funcionario.solicitarBebistaEspecial("Café com calda de chocolate");

        assertTrue(resultado.contains("\n"));
        assertTrue(resultado.contains(">>"));
    }
}
