package ex07;

public class SistemaAutenticacao {
    private final FuncionarioRepository repository;

    public SistemaAutenticacao(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public boolean realizarLogin(String login, String senha) {
        if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
            return false;
        }

        Funcionario funcionario = repository.buscarPorLogin(login);

        // Cenário: Usuário inexistente
        if (funcionario == null) {
            return false;
        }

        // Cenário: Senha incorreta
        if (!funcionario.getSenha().equals(senha)) {
            return false;
        }

        // Cenário: Autenticação realizada com sucesso
        return true;
    }
}
