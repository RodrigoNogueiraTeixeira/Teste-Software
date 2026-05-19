package ex03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: MOCK
 * 
 * Este teste valida a funcionalidade de cadastro de clientes e garante que a
 * notificação de e-mail seja enviada de forma correta ao final do cadastro.
 * O teste utiliza o EmailServiceMock para analisar as interações, verificando
 * se o método enviarEmailBoasVindas foi executado exatamente 1 vez com o cliente correto,
 * tudo sem de fato enviar e-mails de verdade.
 */
public class CadastroClienteServiceTest {

    private EmailServiceMock emailMock;
    private CadastroClienteService cadastroService;

    @BeforeEach
    public void setUp() {
        // Inicializa o mock e o serviço sob teste
        emailMock = new EmailServiceMock();
        cadastroService = new CadastroClienteService(emailMock);
    }

    @Test
    public void deveEnviarEmailBoasVindasAoCadastrarNovoClienteComSucesso() {
        // Arrange
        Cliente cliente = new Cliente("c1", "Carlos Santos", "carlos@email.com");

        // Act
        cadastroService.cadastrarCliente(cliente);

        // Assert
        // 1. Validamos o estado do sistema (cliente adicionado)
        assertEquals(1, cadastroService.getClientesCadastrados().size());
        assertEquals(cliente, cadastroService.getClientesCadastrados().getFirst());

        // 2. Validamos as interações do objeto usando o Mock (comportamento)
        assertEquals(1, emailMock.getQuantidadeChamadas(), "O serviço de e-mail deve ser chamado exatamente 1 vez.");
        assertTrue(emailMock.foiChamadoComSucessoPara(cliente), "O e-mail enviado deve ser endereçado ao cliente recém-cadastrado.");
    }

    @Test
    public void naoDeveAcionarEmailSeOCadastroLancarExcecaoPorClienteNulo() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.cadastrarCliente(null);
        });

        // Garantimos que o mock de e-mail nunca foi invocado devido à falha antes da chamada de envio
        assertEquals(0, emailMock.getQuantidadeChamadas(), "O serviço de e-mail não deve ser chamado em caso de erro.");
    }
}
