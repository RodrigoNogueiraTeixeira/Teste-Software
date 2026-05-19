package ex04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: FAKE
 * 
 * Este teste valida a lógica de gerenciamento de usuários utilizando o FakeUsuarioRepository.
 * O repositório Fake simula com precisão o comportamento de um banco de dados real
 * de forma 100% funcional em memória. O teste valida regras críticas, como a proibição
 * de e-mails duplicados e a listagem correta de usuários cadastrados.
 */
public class GerenciadorUsuarioTest {

    private FakeUsuarioRepository repositoryFake;
    private GerenciadorUsuario gerenciador;

    @BeforeEach
    public void setUp() {
        // Inicializa o repositório Fake e o serviço sob teste
        repositoryFake = new FakeUsuarioRepository();
        gerenciador = new GerenciadorUsuario(repositoryFake);
    }

    @Test
    public void deveCadastrarUsuarioComSucessoUsandoRepositorioFake() {
        // Arrange
        Usuario usuario = new Usuario("Rodrigo Teixeira", "rodrigo@email.com");

        // Act
        gerenciador.cadastrarUsuario(usuario);

        // Assert
        // O Fake permite buscar de verdade o usuário que foi salvo em memória
        Usuario buscado = repositoryFake.buscarPorEmail("rodrigo@email.com");
        assertNotNull(buscado, "O usuário deveria ter sido salvo.");
        assertEquals("Rodrigo Teixeira", buscado.getNome());
    }

    @Test
    public void deveLancarExcecaoQuandoCadastrarUsuarioComEmailDuplicado() {
        // Arrange
        Usuario u1 = new Usuario("Ana Costa", "ana@email.com");
        Usuario u2 = new Usuario("Ana Maria", "ana@email.com"); // E-mail duplicado
        
        gerenciador.cadastrarUsuario(u1);

        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            gerenciador.cadastrarUsuario(u2);
        });

        assertEquals("Já existe um usuário cadastrado com este e-mail.", exception.getMessage());
    }

    @Test
    public void deveListarTodosOsUsuariosCadastradosComSucesso() {
        // Arrange
        Usuario u1 = new Usuario("Bruno Lima", "bruno@email.com");
        Usuario u2 = new Usuario("Clara Dias", "clara@email.com");

        gerenciador.cadastrarUsuario(u1);
        gerenciador.cadastrarUsuario(u2);

        // Act
        List<Usuario> listagem = gerenciador.obterTodosUsuarios();

        // Assert
        assertEquals(2, listagem.size(), "Deveriam existir 2 usuários na listagem.");
        assertTrue(listagem.stream().anyMatch(u -> u.getEmail().equals("bruno@email.com")));
        assertTrue(listagem.stream().anyMatch(u -> u.getEmail().equals("clara@email.com")));
    }
}
