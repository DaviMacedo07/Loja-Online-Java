package Classes;

import abstractClass.Produto;

public class MatrizProdutos extends Produto {

    private Produto[][] produtos;

    public MatrizProdutos(int quantidadeDeProdutos) {
        produtos = new Produto[quantidadeDeProdutos][1];
    }

    public void adicionarProduto(int index, Produto produto) {
        if (index < produtos.length) {
            produtos[index][0] = produto;
        } else {
            System.out.println("Índice fora do intervalo.");
        }
    }

    public void exibirProdutos() {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i][0] != null) {
                // Exibe como "Produto 1", "Produto 2", etc.
                System.out.println("Produto " + (i + 1) + ": " + produtos[i][0].getMarca() + " | Preço: R$ " + produtos[i][0].getPreco());
            }
        }
    }
}
