package ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {
    private final List<Produto> bancoDadosReal = new ArrayList<>();

    public void salvar(Produto produto) {
        bancoDadosReal.add(produto);
    }

    public Optional<Produto> buscarPorId(String id) {
        return bancoDadosReal.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(bancoDadosReal);
    }
}
