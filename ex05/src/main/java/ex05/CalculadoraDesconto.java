package ex05;

public class CalculadoraDesconto {

    private static final double VALOR_MINIMO_DESCONTO = 500.00;
    private static final double PERCENTUAL_DESCONTO = 0.15; // 15% de desconto para compras acima de R$ 500

    public double calcularDescontoPremium(double valorCompra) {
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser estritamente maior que zero.");
        }

        if (valorCompra > VALOR_MINIMO_DESCONTO) {
            return valorCompra * PERCENTUAL_DESCONTO;
        }

        return 0.0; // Sem desconto para valores menores ou iguais ao mínimo
    }
}
