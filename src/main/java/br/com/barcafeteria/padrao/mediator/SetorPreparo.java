package br.com.barcafeteria.padrao.mediator;

public interface SetorPreparo {
    
    String receberPedido(String mensagem);
    
    boolean estaDisponivel();
    
    int obterTempoEstimado();
}
