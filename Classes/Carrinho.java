package Classes;

import abstractClass.Produto;
import abstractClass.Vendas;

import java.util.ArrayList;

public class Carrinho implements Vendas {
    private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();  // Adiciona o preço de cada produto no total
        }
        return total;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void adicionarAoCarrinho(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
            System.out.println(produto.getMarca() + " adicionado com sucesso!");
        }
        if (produto == null) {
            System.out.println("Erro: Produto não pode ser nulo.");
            return;
        }

//        try {
//            throw new RuntimeException("Simulação de erro ao adicionar produto");
//        } catch (Exception e) {
//            System.out.println("Erro inesperado ao adicionar produto: " + e.getMessage());
//        }
    }

    @Override
    public void adicionarAoCarrinho() {

    }

    @Override
    public void removerDoCarrinho() {

    }

    @Override
    public void removerDoCarrinho(Produto produto) {
        if (produtos.contains(produto)) {
            produtos.remove(produto);
            System.out.println("Produto removido do carrinho: " + produto.getMarca());
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }


    @Override
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Produtos no carrinho:");
            for (Produto produto : produtos) {
                System.out.println("- " + produto.getMarca() + " | Preço: R$ " + produto.getPreco());
            }
        }
    }
}
