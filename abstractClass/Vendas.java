package abstractClass;

import Classes.Carrinho;
import Classes.Pedido;

public interface Vendas {
    void adicionarAoCarrinho();

    void removerDoCarrinho();

    void removerDoCarrinho(Produto produto);

    void listarProdutos();

    void adicionarAoCarrinho(Produto produto);
}
