package br.com.barcafeteria.padrao.mediator;

public class Bar implements SetorPreparo {

    private static Bar instancia = new Bar();
    private boolean disponivel = true;
    private int tempoEstimado = 3;

    private Bar() {
    }

    public static Bar getInstancia() {
        return instancia;
    }

    @Override
    public String receberPedido(String mensagem) {
        return "O Bar está preparando a bebida alcoólica: " + mensagem;
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
