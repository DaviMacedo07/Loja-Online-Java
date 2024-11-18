package Classes;

import abstractClass.Produto;
import abstractClass.Vendas;

import java.util.ArrayList;

public class Carrinho implements Vendas {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    // Adiciona um produto ao carrinho
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Remove um produto do carrinho
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // Calcula o total do carrinho, multiplicando o preço pela quantidade de cada produto
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    // Lista todos os produtos no carrinho com suas informações
    public void listarProdutos() {
        for (Produto produto : produtos) {
            produto.exibirInformacoes();
        }
    }

    // Métodos da Interface Vendas

    @Override
    public void adicionarAoCarrinho(Carrinho carrinho) {
        System.out.println("Este carrinho já está sendo utilizado.");
    }

    @Override
    public void removerDoCarrinho(Carrinho carrinho) {
        carrinho.produtos.clear();
        System.out.println("Todos os produtos foram removidos do carrinho.");
    }

    @Override
    public void finalizarPedido(Pedido pedido) {
        pedido.processarPedido();
        System.out.println("Pedido finalizado para todos os produtos do carrinho.");
    }
}
