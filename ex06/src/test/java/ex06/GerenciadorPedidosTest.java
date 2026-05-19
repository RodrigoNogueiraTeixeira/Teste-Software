package ex06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Este teste automatiza a validação da finalização de pedidos utilizando o ServicoPagamentoStub.
 * Simulamos isoladamente cenários de pagamentos aprovados e recusados, garantindo que o status
 * interno do pedido mude adequadamente, sem que ocorra qualquer acesso a APIs reais de pagamento.
 */
public class GerenciadorPedidosTest {

    private ServicoPagamentoStub pagamentoStub;
    private GerenciadorPedidos gerenciador;

    @BeforeEach
    public void setUp() {
        pagamentoStub = new ServicoPagamentoStub();
        gerenciador = new GerenciadorPedidos(pagamentoStub);
    }

    @Test
    public void deveConfirmarPedidoQuandoPagamentoForAprovadoPeloStub() {
        // Arrange
        Pedido pedido = new Pedido(1, 150.00);
        pagamentoStub.configurarRetorno(true); // Stub configurado para APROVAR

        // Act
        boolean resultado = gerenciador.finalizarPedido(pedido);

        // Assert
        assertTrue(resultado, "A finalização do pedido deve retornar verdadeiro.");
        assertEquals("APROVADO", pedido.getStatus(), "O status do pedido deve mudar para APROVADO.");
    }

    @Test
    public void deveRecusarPedidoQuandoPagamentoForRecusadoPeloStub() {
        // Arrange
        Pedido pedido = new Pedido(2, 280.00);
        pagamentoStub.configurarRetorno(false); // Stub configurado para RECUSAR

        // Act
        boolean resultado = gerenciador.finalizarPedido(pedido);

        // Assert
        assertFalse(resultado, "A finalização do pedido deve retornar falso.");
        assertEquals("RECUSADO", pedido.getStatus(), "O status do pedido deve mudar para RECUSADO.");
    }

    @Test
    public void deveLancarExcecaoQuandoPedidoForNulo() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            gerenciador.finalizarPedido(null);
        });
    }
}
