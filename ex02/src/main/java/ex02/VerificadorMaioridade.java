package ex02;

public class VerificadorMaioridade {
    private final AlunoRepository repository;

    public VerificadorMaioridade(AlunoRepository repository) {
        this.repository = repository;
    }

    public boolean podeParticiparEvento(int alunoId) {
        Aluno aluno = repository.buscarPorId(alunoId);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado com o ID fornecido.");
        }
        return aluno.getIdade() >= 18;
    }
}
