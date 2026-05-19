package ex01;

/**
 * TIPO DE OBJETO DE TESTE: DUMMY
 * 
 * Um objeto Dummy é utilizado quando um componente exige uma dependência para ser
 * instanciado ou estruturado, mas essa dependência não é de fato utilizada ou
 * exercitada durante a execução do teste. Ele serve exclusivamente para preencher
 * a assinatura de métodos ou construtores (satisfazer a estrutura da aplicação).
 */
public class DummyLogger implements Logger {
    @Override
    public void log(String message) {
        // Um objeto Dummy não realiza nenhuma ação e não possui comportamento implementado.
        // Ele serve apenas para preencher o parâmetro do construtor da Calculadora.
    }
}
