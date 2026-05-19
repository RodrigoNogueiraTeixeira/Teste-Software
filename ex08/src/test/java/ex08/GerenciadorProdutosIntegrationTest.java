package ex08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE TESTE: TESTE DE INTEGRAÇÃO (COMPONENTES REAIS)
 * 
 * O foco deste exercício é diferenciar os testes unitários isolados dos testes de integração.
 * Ao contrário dos testes unitários clássicos que utilizam dublês de teste (Mocks/Stubs),
 * este teste utiliza componentes REAIS e CONCRETOS da aplicação trabalhando em conjunto:
 * GerenciadorProdutos (Serviço) + ProdutoRepository (Repositório Real) + Produto (Entidade Real).
 * Validamos o fluxo ponta a ponta (cadastrar, consultar e listar produtos) para garantir que
 * a integração e colaboração entre múltiplos componentes reais funciona corretamente.
 */
public class GerenciadorProdutosIntegrationTest {

    private ProdutoRepository repositoryReal;
    private GerenciadorProdutos gerenciador;

    @BeforeEach
    public void setUp() {
        // Inicializando os componentes reais concretos que trabalharão juntos
        repositoryReal = new ProdutoRepository();
        gerenciador = new GerenciadorProdutos(repositoryReal);
    }

    @Test
    public void deveIntegrarCadastroEConsultaDeProdutosComComponentesReais() {
        // Arrange
        Produto p1 = new Produto("p01", "Teclado Mecânico", 350.00);

        // Act - Cadastra usando o gerenciador, que persistirá no repositório real
        gerenciador.cadastrarProduto(p1);

        // Act - Consulta o produto cadastrado
        Produto retornado = gerenciador.consultarProduto("p01");

        // Assert - Validamos que a integração entre Gerenciador e Repositório funcionou com sucesso
        assertNotNull(retornado, "O produto deveria ter sido recuperado.");
        assertEquals("Teclado Mecânico", retornado.getNome());
        assertEquals(350.00, retornado.getPreco(), 0.001);
    }

    @Test
    public void deveLancarExcecaoQuandoTentarCadastrarProdutoDuplicado() {
        // Arrange
        Produto p1 = new Produto("p02", "Mouse Gamer", 180.00);
        Produto p2 = new Produto("p02", "Mouse Gamer Wireless", 299.90); // ID duplicado

        gerenciador.cadastrarProduto(p1);

        // Act & Assert - A tentativa de duplicar deve disparar exceção baseando-se nos dados reais salvos
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            gerenciador.cadastrarProduto(p2);
        });

        assertEquals("Produto com este ID já cadastrado.", exception.getMessage());
    }

    @Test
    public void deveIntegrarListagemGeralDeTodosOsProdutosCadastrados() {
        // Arrange
        Produto p1 = new Produto("p03", "Monitor 24' IPS", 899.90);
        Produto p2 = new Produto("p04", "Headset Bluetooth", 249.00);

        gerenciador.cadastrarProduto(p1);
        gerenciador.cadastrarProduto(p2);

        // Act
        List<Produto> lista = gerenciador.listarProdutos();

        // Assert
        assertEquals(2, lista.size(), "Devem existir 2 produtos cadastrados na lista real.");
        assertTrue(lista.stream().anyMatch(p -> p.getId().equals("p03")));
        assertTrue(lista.stream().anyMatch(p -> p.getId().equals("p04")));
    }
}
