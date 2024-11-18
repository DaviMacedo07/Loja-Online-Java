package Test;

import Classes.*;
import abstractClass.Produto;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Silva", "joao@gmail.com", "1234", "Rua A, 123");
        Vendedor vendedor = new Vendedor("Maria Lopes", "maria@loja.com", "senha123", "12345678000100", 10.0);

        Produto camisa = new Roupa("Camisa Polo", 59.90, 10, "M", "Azul");
        Produto celular = new Eletronico("Smartphone", 1200.00, 5, "Samsung", 12);

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(camisa);
        carrinho.adicionarProduto(celular);

        Pedido pedido = new Pedido(carrinho, cliente);

        // Calcula o total do carrinho
        double total = carrinho.calcularTotal();
        System.out.println("Total do pedido: R$ " + total);

        // Cria a instância de Pagamento passando o valor e o método
        Pagamento pagamento = new Pagamento();

        // Processa o pedido e realiza o pagamento
        pedido.processarPedido();

        if (pagamento.realizarPagamento(total, "cartao")) {
            pedido.concluirPedido();
        } else {
            pedido.cancelarPedido();
        }
    }
}
