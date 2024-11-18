package abstractClass;

import Classes.Carrinho;
import Classes.Pedido;

public interface Vendas {
    void adicionarAoCarrinho(Carrinho carrinho);

    void removerDoCarrinho(Carrinho carrinho);

    void finalizarPedido(Pedido pedido);
}
