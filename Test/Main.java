package Test;

import Classes.*;
import abstractClass.Produto;
import abstractClass.Processavel;
import abstractClass.Vendas;

public class Main {
    public static void main(String[] args) {
       Cliente cliente = new Cliente("Davi", "davi@1234", "123");
       cliente.setEndereco("Rua Egidio de Oliveira 108");
       cliente.exibirInformacoes();

       System.out.println("_*_*_*_*_*_*_*_CLIENTE_*_*_*_*_*_*_*_");
       System.out.println();

       Vendedor vendedor1 = new Vendedor("Jordan da Silva", "jordan@123", "333", 0.12, 600);
       vendedor1.exibirInformacoes();
       System.out.println(" ");
       System.out.println("_*_*_*_*_*_*_*VENDEDOR*_*_*_*_*_*_*_");
       System.out.println();

       Roupa roupa = new Roupa("Camisa Hering", 250, 4, 'M', "Amarela");
       roupa.exibirInformacoes();


     //  Produto produto = new Roupa("Hering", 250, 4, 'M', "Amarela");
       // linha que eu coloco exemplo de try catch

       Carrinho carrinho = new Carrinho();
       Eletronico eletronico1 = new Eletronico("Geladeira Eletrolux", 3500, 4);
       eletronico1.setWt(220);
       eletronico1.exibirInformacoes();
       carrinho.adicionarAoCarrinho(eletronico1);
       carrinho.adicionarAoCarrinho(roupa);
       System.out.println("");
       System.out.println("_*_*_*_*_*_*_*PRODUTO*_*_*_*_*_*_*_");
       System.out.println("");

       System.out.println("Preço da camisa SEM DESCONTO: " + roupa.getPreco());
       roupa.aplicarDesconto(15);
       System.out.println("Novo preço da camisa com o desconto: " + roupa.getPreco());
       carrinho.listarProdutos();

       System.out.println("_*_*_*_*_*_*_*CARRINHO*_*_*_*_*_*_*_");
       System.out.println("");

       System.out.println("Total da compra: " + carrinho.calcularTotal());

       Pedido pedido = new Pedido(cliente, carrinho);
       pedido.processarPedido();
       pedido.concluirPedido();
      // AQUI É O ADICIONAR DO TRY CATCH carrinho.adicionarAoCarrinho(produto);

       System.out.println("");
       System.out.println("_*_*_*_*_*_*_*PAGAMENTO*_*_*_*_*_*_*_");

       Pagamento pagamento = new Pagamento(carrinho, "Cartão de Débito");
       pagamento.validarPagamento();
       pagamento.processarPagamento();
     //  pagamento.realizarPagamento();

       System.out.println("");
       System.out.println("_*_*_*_*_*_*_*MATRIZ-DE-PRODUTOS*_*_*_*_*_*_*_");

       MatrizProdutos matrizProdutos = new MatrizProdutos(2);
       matrizProdutos.adicionarProduto(0, roupa);
       matrizProdutos.adicionarProduto(1, eletronico1);
       matrizProdutos.exibirProdutos();
    }
}
