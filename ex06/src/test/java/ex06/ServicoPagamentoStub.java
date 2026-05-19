package ex06;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Um Stub é um dublê de teste que fornece respostas pré-definidas (canned answers)
 * para simular o comportamento de dependências externas. Nesse cenário, o stub simula
 * a chamada do serviço de pagamento externo (gateway de pagamento), permitindo forçar
 * retornos controlados (aprovação ou recusa) sem realizar requisições de verdade via internet.
 */
public class ServicoPagamentoStub implements ServicoPagamento {
    private boolean respostaAprovada;

    // Método para configurar o retorno que o Stub deve dar no teste
    public void configurarRetorno(boolean aprovada) {
        this.respostaAprovada = aprovada;
    }

    @Override
    public boolean autorizarPagamento(Pedido pedido) {
        // Retorna a resposta pré-configurada pelo cenário de teste
        return respostaAprovada;
    }
}
