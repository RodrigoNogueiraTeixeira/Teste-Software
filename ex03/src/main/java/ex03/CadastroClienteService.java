package ex03;

import java.util.ArrayList;
import java.util.List;

public class CadastroClienteService {
    private final EmailService emailService;
    private final List<Cliente> clientesCadastrados = new ArrayList<>();

    public CadastroClienteService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        
        // Simulação do cadastro
        clientesCadastrados.add(cliente);

        // Dispara o e-mail de boas-vindas utilizando o componente de comunicação
        emailService.enviarEmailBoasVindas(cliente);
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }
}
