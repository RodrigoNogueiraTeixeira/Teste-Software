package ex03;

import java.util.ArrayList;
import java.util.List;

/**
 * TIPO DE OBJETO DE TESTE: MOCK
 * 
 * Um Mock é um objeto de teste utilizado para verificar a interação entre objetos.
 * Ele grava informações sobre as chamadas recebidas (quais métodos foram executados,
 * quantas vezes foram chamados e quais argumentos foram passados) para permitir que
 * o teste valide se as interações de fato aconteceram conforme esperado (verificação de comportamento).
 */
public class EmailServiceMock implements EmailService {
    private final List<Cliente> clientesNotificados = new ArrayList<>();
    private int quantidadeChamadas = 0;

    @Override
    public void enviarEmailBoasVindas(Cliente cliente) {
        this.quantidadeChamadas++;
        this.clientesNotificados.add(cliente);
    }

    public int getQuantidadeChamadas() {
        return quantidadeChamadas;
    }

    public List<Cliente> getClientesNotificados() {
        return clientesNotificados;
    }

    // Método auxiliar para verificar se a chamada ocorreu para um cliente específico
    public boolean foiChamadoComSucessoPara(Cliente cliente) {
        return clientesNotificados.contains(cliente);
    }
}
