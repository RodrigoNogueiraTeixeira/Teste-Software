package ex07;

import java.util.HashMap;
import java.util.Map;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Este Stub simula a camada de busca de funcionários (FuncionarioRepository)
 * fornecendo respostas estáticas pré-programadas para os testes. Ele permite retornar
 * dados de funcionários previamente registrados ou retornar nulo para simular funcionários
 * inexistentes de forma totalmente previsível e sem acessar nenhum banco de dados real.
 */
public class FuncionarioRepositoryStub implements FuncionarioRepository {
    private final Map<String, Funcionario> funcionariosCadastrados = new HashMap<>();

    // Método para cadastrar respostas prontas/controladas no stub
    public void adicionarFuncionarioParaTeste(Funcionario funcionario) {
        funcionariosCadastrados.put(funcionario.getLogin(), funcionario);
    }

    @Override
    public Funcionario buscarPorLogin(String login) {
        // Retorna a resposta pré-configurada controlada pelo teste
        return funcionariosCadastrados.get(login);
    }
}
