package ex01;

public class Calculadora {
    private final Logger logger;

    // A dependência é exigida no construtor para satisfazer a estrutura da aplicação.
    public Calculadora(Logger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("O Logger não pode ser nulo.");
        }
        this.logger = logger;
    }

    public int somar(int a, int b) {
        // Inicialmente, os cálculos não utilizam o logger, mas a dependência precisa estar presente
        return a + b;
    }
}
