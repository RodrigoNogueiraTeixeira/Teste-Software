package ex02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Este teste valida o Verificador de Maioridade utilizando o AlunoRepositoryStub.
 * O Stub é programado antes de cada caso de teste para fornecer as informações exatas
 * de idade necessárias para testar as regras de participação do evento acadêmico,
 * sem acessar qualquer banco de dados ou serviço externo real.
 */
public class VerificadorMaioridadeTest {

    private AlunoRepositoryStub repositoryStub;
    private VerificadorMaioridade verificador;

    @BeforeEach
    public void setUp() {
        // Inicializa o stub e o serviço
        repositoryStub = new AlunoRepositoryStub();
        verificador = new VerificadorMaioridade(repositoryStub);
    }

    @Test
    public void devePermitirParticipacaoQuandoAlunoForMaiorDeIdade() {
        // Arrange
        // Configura o stub para retornar um aluno com 18 anos
        Aluno alunoMaior = new Aluno(1, "João", 18);
        repositoryStub.adicionarAlunoParaTeste(alunoMaior);

        // Act
        boolean resultado = verificador.podeParticiparEvento(1);

        // Assert
        assertTrue(resultado, "Aluno com 18 anos deve ser autorizado a participar.");
    }

    @Test
    public void deveNegarParticipacaoQuandoAlunoForMenorDeIdade() {
        // Arrange
        // Configura o stub para retornar um aluno com 17 anos
        Aluno alunoMenor = new Aluno(2, "Maria", 17);
        repositoryStub.adicionarAlunoParaTeste(alunoMenor);

        // Act
        boolean resultado = verificador.podeParticiparEvento(2);

        // Assert
        falseValueAssert(resultado); // Utilizando asserção do JUnit
    }

    private void falseValueAssert(boolean value) {
        assertFalse(value, "Aluno com 17 anos não deve ser autorizado a participar.");
    }

    @Test
    public void deveLancarExcecaoQuandoAlunoNaoForEncontrado() {
        // Act & Assert
        // Nenhum aluno foi adicionado ao stub para o ID 999
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            verificador.podeParticiparEvento(999);
        });

        assertEquals("Aluno não encontrado com o ID fornecido.", exception.getMessage());
    }
}
