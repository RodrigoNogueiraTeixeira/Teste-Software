package ex07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Este teste automatiza a validação do sistema de autenticação de funcionários de forma isolada.
 * Utilizando o FuncionarioRepositoryStub, validamos as três regras cruciais de login:
 * 1. Falha de login por Usuário Inexistente (o stub retorna nulo).
 * 2. Falha de login por Senha Incorreta (o stub retorna o funcionário, mas com senha divergente).
 * 3. Sucesso de autenticação (o stub retorna o funcionário e as credenciais batem perfeitamente).
 */
public class SistemaAutenticacaoTest {

    private FuncionarioRepositoryStub repositoryStub;
    private SistemaAutenticacao sistemaAutenticacao;

    @BeforeEach
    public void setUp() {
        repositoryStub = new FuncionarioRepositoryStub();
        sistemaAutenticacao = new SistemaAutenticacao(repositoryStub);
    }

    @Test
    public void deveRecusarLoginQuandoUsuarioNaoExistirNoStub() {
        // Arrange
        // Não adicionamos nenhum usuário com o login "usuario.inexistente" no stub
        
        // Act
        boolean resultado = sistemaAutenticacao.realizarLogin("usuario.inexistente", "senha123");

        // Assert
        assertFalse(resultado, "O login não deve ser permitido para usuários inexistentes.");
    }

    @Test
    public void deveRecusarLoginQuandoSenhaEstiverIncorreta() {
        // Arrange
        // Adicionamos um funcionário com a senha "senhaCorreta"
        Funcionario func = new Funcionario("rodrigo.teixeira", "senhaCorreta", "Rodrigo Nogueira");
        repositoryStub.adicionarFuncionarioParaTeste(func);

        // Act
        boolean resultado = sistemaAutenticacao.realizarLogin("rodrigo.teixeira", "senhaIncorreta");

        // Assert
        assertFalse(resultado, "O login não deve ser permitido com senha incorreta.");
    }

    @Test
    public void deveAutenticarComSucessoQuandoCredenciaisForemCorretas() {
        // Arrange
        // Adicionamos um funcionário com credenciais corretas
        Funcionario func = new Funcionario("rodrigo.teixeira", "senha123", "Rodrigo Nogueira");
        repositoryStub.adicionarFuncionarioParaTeste(func);

        // Act
        boolean resultado = sistemaAutenticacao.realizarLogin("rodrigo.teixeira", "senha123");

        // Assert
        assertTrue(resultado, "O login deve ser realizado com sucesso se as credenciais baterem.");
    }
}
