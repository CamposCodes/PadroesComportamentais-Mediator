package br.com.barcafeteria.padrao.mediator;

public class Cozinha implements SetorPreparo {

    private static Cozinha instancia = new Cozinha();
    private boolean disponivel = true;
    private int tempoEstimado = 15;

    private Cozinha() {
    }

    public static Cozinha getInstancia() {
        return instancia;
    }

    @Override
    public String receberPedido(String mensagem) {
        return "A Cozinha está preparando o alimento: " + mensagem;
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
