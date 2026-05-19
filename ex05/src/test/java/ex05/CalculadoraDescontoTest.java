package ex05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TIPO DE TESTE: TESTE UNITÁRIO (VERIFICAÇÃO DE ESTADO)
 * 
 * Este exercício foca em testes unitários puros, sem o uso de dublês de teste (Mocks/Stubs),
 * pois a classe testada não possui dependências externas. O objetivo é validar o comportamento
 * interno da regra de cálculo de descontos (verificação de estado) cobrindo diferentes
 * caminhos de execução da lógica de negócios: valores válidos com desconto, valores válidos
 * sem desconto e limites de entradas inválidas.
 */
public class CalculadoraDescontoTest {

    private CalculadoraDesconto calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new CalculadoraDesconto();
    }

    @Test
    public void deveAplicarDescontoQuandoValorForSuperiorAoMinimo() {
        // Arrange & Act
        double desconto = calculadora.calcularDescontoPremium(600.00); // 600 é > 500

        // Assert
        assertEquals(90.00, desconto, 0.001, "O desconto de 15% para R$ 600 deve ser R$ 90.");
    }

    @Test
    public void naoDeveAplicarDescontoQuandoValorForIgualAoMinimo() {
        // Arrange & Act
        double desconto = calculadora.calcularDescontoPremium(500.00); // Exatamente o limite mínimo

        // Assert
        assertEquals(0.00, desconto, 0.001, "Não deve haver desconto para valor igual ao limite mínimo (R$ 500).");
    }

    @Test
    public void naoDeveAplicarDescontoQuandoValorForMenorQueOMinimo() {
        // Arrange & Act
        double desconto = calculadora.calcularDescontoPremium(350.00); // Menor que o limite mínimo

        // Assert
        assertEquals(0.00, desconto, 0.001, "Não deve haver desconto para compras de R$ 350.");
    }

    @Test
    public void deveLancarExcecaoQuandoValorForZero() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularDescontoPremium(0.0);
        });

        assertEquals("O valor da compra deve ser estritamente maior que zero.", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoQuandoValorForNegativo() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularDescontoPremium(-50.0);
        });

        assertEquals("O valor da compra deve ser estritamente maior que zero.", exception.getMessage());
    }
}
