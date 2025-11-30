package br.com.barcafeteria.padrao.mediator;

public class CozinhaBar {

    private static CozinhaBar instancia = new CozinhaBar();

    private CozinhaBar() {
    }

    public static CozinhaBar getInstancia() {
        return instancia;
    }

    public String receberPedidoBebidaAlcoolica(String mensagem) {
        return "Cozinha/Bar recebeu o pedido.\n" +
                "Encaminhando para o Bar conforme pedido a seguir.\n" +
                ">>" + Bar.getInstancia().receberPedido(mensagem);
    }

    public String receberPedidoAlimento(String mensagem) {
        return "Cozinha/Bar recebeu o pedido.\n" +
                "Encaminhando para a Cozinha conforme pedido a seguir.\n" +
                ">>" + Cozinha.getInstancia().receberPedido(mensagem);
    }

    public String receberPedidoBebistaEspecial(String mensagem) {
        return "Cozinha/Bar recebeu o pedido.\n" +
                "Encaminhando para o Barista conforme pedido a seguir.\n" +
                ">>" + Barista.getInstancia().receberPedido(mensagem);
    }

    public String verificarDisponibilidadeSetores() {
        StringBuilder status = new StringBuilder();
        status.append("Status dos Setores:\n");
        status.append("Bar: ").append(Bar.getInstancia().estaDisponivel() ? "Disponível" : "Ocupado").append("\n");
        status.append("Cozinha: ").append(Cozinha.getInstancia().estaDisponivel() ? "Disponível" : "Ocupada").append("\n");
        status.append("Barista: ").append(Barista.getInstancia().estaDisponivel() ? "Disponível" : "Ocupado");
        return status.toString();
    }

    public String obterTemposEstimados() {
        StringBuilder tempos = new StringBuilder();
        tempos.append("Tempos Estimados de Preparo:\n");
        tempos.append("Bar: ").append(Bar.getInstancia().obterTempoEstimado()).append(" minutos\n");
        tempos.append("Cozinha: ").append(Cozinha.getInstancia().obterTempoEstimado()).append(" minutos\n");
        tempos.append("Barista: ").append(Barista.getInstancia().obterTempoEstimado()).append(" minutos");
        return tempos.toString();
    }
}
