package ex04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TIPO DE OBJETO DE TESTE: FAKE
 * 
 * Um Fake é uma implementação simplificada, porém funcional, de uma dependência
 * real da aplicação (como um banco de dados). Embora possua lógica real interna
 * (consegue salvar, buscar e listar elementos), ele utiliza atalhos (como salvar
 * os dados em memória RAM usando um Map ou List) que inviabilizam o seu uso
 * em ambiente de produção, mas são ideais para testes rápidos e isolados.
 */
public class FakeUsuarioRepository implements UsuarioRepository {
    // Banco de dados simulado em memória (RAM)
    private final Map<String, Usuario> bancoEmMemoria = new HashMap<>();

    @Override
    public void salvar(Usuario usuario) {
        bancoEmMemoria.put(usuario.getEmail(), usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return bancoEmMemoria.get(email);
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(bancoEmMemoria.values());
    }
}
