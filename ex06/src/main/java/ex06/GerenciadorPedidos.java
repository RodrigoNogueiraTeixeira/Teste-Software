package ex06;

public class GerenciadorPedidos {
    private final ServicoPagamento servicoPagamento;

    public GerenciadorPedidos(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    public boolean finalizarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }

        // Consultamos o serviço de pagamento (dependência)
        boolean aprovado = servicoPagamento.autorizarPagamento(pedido);

        if (aprovado) {
            pedido.setStatus("APROVADO");
            return true;
        } else {
            pedido.setStatus("RECUSADO");
            return false;
        }
    }
}
