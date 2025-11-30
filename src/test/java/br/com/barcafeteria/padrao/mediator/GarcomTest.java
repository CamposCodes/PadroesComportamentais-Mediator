package br.com.barcafeteria.padrao.mediator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GarcomTest {

    private Garcom garcom;

    @BeforeEach
    void setUp() {
        garcom = new Garcom();
    }

    @Test
    void deveSolicitarBebidaAlcoolica() {
        String resultado = garcom.solicitarBebidaAlcoolica("Água com gás");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Bar"));
        assertTrue(resultado.contains("bebida alcoólica"));
    }

    @Test
    void deveSolicitarAlimento() {
        String resultado = garcom.solicitarAlimento("Pastel de queijo");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(resultado.contains("alimento"));
    }

    @Test
    void deveSolicitarBebistaEspecial() {
        String resultado = garcom.solicitarBebistaEspecial("Espresso duplo");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Barista"));
        assertTrue(resultado.contains("bebida especial"));
    }

    @Test
    void deveHerdarComportamentoDeFuncionario() {
        assertTrue(garcom instanceof Funcionario);
    }
}
