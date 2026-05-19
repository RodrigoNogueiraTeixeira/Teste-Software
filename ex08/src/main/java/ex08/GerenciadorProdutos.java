package ex08;

import java.util.List;

public class GerenciadorProdutos {
    private final ProdutoRepository repository;

    public GerenciadorProdutos(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (produto.getId() == null || produto.getId().isBlank()) {
            throw new IllegalArgumentException("ID do produto inválido.");
        }
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do produto inválido.");
        }
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo.");
        }

        // Impedir IDs duplicados de produto
        if (repository.buscarPorId(produto.getId()).isPresent()) {
            throw new IllegalStateException("Produto com este ID já cadastrado.");
        }

        repository.salvar(produto);
    }

    public Produto consultarProduto(String id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
    }

    public List<Produto> listarProdutos() {
        return repository.listarTodos();
    }
}
