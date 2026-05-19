package ex04;

import java.util.List;

public class GerenciadorUsuario {
    private final UsuarioRepository repository;

    public GerenciadorUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-mail do usuário inválido.");
        }

        // Regra de negócio: não permite cadastrar usuários com o mesmo e-mail
        Usuario existente = repository.buscarPorEmail(usuario.getEmail());
        if (existente != null) {
            throw new IllegalStateException("Já existe um usuário cadastrado com este e-mail.");
        }

        repository.salvar(usuario);
    }

    public List<Usuario> obterTodosUsuarios() {
        return repository.listarTodos();
    }
}
