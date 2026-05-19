package ex02;

import java.util.HashMap;
import java.util.Map;

/**
 * TIPO DE OBJETO DE TESTE: STUB
 * 
 * Um Stub é um objeto de teste que fornece respostas pré-programadas (canned answers)
 * para as chamadas realizadas durante a execução de um teste. Ele é utilizado quando
 * queremos controlar exatamente os retornos de uma dependência (como um banco de dados,
 * API externa ou outro serviço) para simular diferentes cenários de teste de forma estável.
 */
public class AlunoRepositoryStub implements AlunoRepository {
    private final Map<Integer, Aluno> alunosPreDefinidos = new HashMap<>();

    // Permite ao teste configurar previamente os retornos desejados do componente
    public void adicionarAlunoParaTeste(Aluno aluno) {
        alunosPreDefinidos.put(aluno.getId(), aluno);
    }

    @Override
    public Aluno buscarPorId(int id) {
        // Retorna sempre o valor controlado e configurado previamente pelo teste
        return alunosPreDefinidos.get(id);
    }
}
