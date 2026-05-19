package ex07;

public class Funcionario {
    private final String login;
    private final String senha;
    private final String nome;

    public Funcionario(String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }
}
