package br.com.barcafeteria.padrao.mediator;

public class Barista implements SetorPreparo {

    private static Barista instancia = new Barista();
    private boolean disponivel = true;
    private int tempoEstimado = 5;

    private Barista() {
    }

    public static Barista getInstancia() {
        return instancia;
    }

    @Override
    public String receberPedido(String mensagem) {
        return "O Barista está preparando a bebida especial: " + mensagem;
    }

    @Override
    public boolean estaDisponivel() {
        return disponivel;
    }

    @Override
    public int obterTempoEstimado() {
        return tempoEstimado;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
}
