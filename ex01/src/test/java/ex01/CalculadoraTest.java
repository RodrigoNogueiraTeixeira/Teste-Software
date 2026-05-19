package ex01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE OBJETO DE TESTE: DUMMY
 * 
 * O objetivo deste teste é demonstrar o uso de um objeto Dummy (DummyLogger).
 * O DummyLogger é fornecido ao construtor da classe Calculadora apenas para satisfazer
 * a dependência exigida na estrutura da aplicação. O teste valida que a operação
 * de soma funciona corretamente sem que a dependência de log influencie no resultado.
 */
public class CalculadoraTest {

    @Test
    public void deveSomarDoisNumerosInteirosComSucessoUsandoDummyLogger() {
        // Arrange
        Logger dummyLogger = new DummyLogger(); // Criando o objeto Dummy
        Calculadora calculadora = new Calculadora(dummyLogger); // Passando o Dummy para o construtor

        // Act
        int resultado = calculadora.somar(5, 7);

        // Assert
        assertEquals(12, resultado, "A soma de 5 e 7 deve ser igual a 12.");
    }

    @Test
    public void deveLancarExcecaoQuandoLoggerForNulo() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Calculadora(null);
        });

        assertEquals("O Logger não pode ser nulo.", exception.getMessage());
    }
}
