package ex02;

public class Aluno {
    private final int id;
    private final String nome;
    private final int idade;

    public Aluno(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
