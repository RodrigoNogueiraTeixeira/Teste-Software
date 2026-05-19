package ex04;

import java.util.List;

public interface UsuarioRepository {
    void salvar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    List<Usuario> listarTodos();
}
