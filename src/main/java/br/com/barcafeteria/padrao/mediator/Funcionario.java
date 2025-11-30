package br.com.barcafeteria.padrao.mediator;

public class Funcionario {

    public String solicitarBebidaAlcoolica(String mensagem) {
        return CozinhaBar.getInstancia().receberPedidoBebidaAlcoolica(mensagem);
    }

    public String solicitarAlimento(String mensagem) {
        return CozinhaBar.getInstancia().receberPedidoAlimento(mensagem);
    }

    public String solicitarBebistaEspecial(String mensagem) {
        return CozinhaBar.getInstancia().receberPedidoBebistaEspecial(mensagem);
    }
}
