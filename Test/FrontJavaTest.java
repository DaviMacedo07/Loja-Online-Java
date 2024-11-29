package Test;

import Classes.Carrinho;
import Classes.Eletronico;
import Classes.Pagamento;
import abstractClass.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontJavaTest {
    private JFrame frame;
    private Carrinho carrinho;

    public FrontJavaTest() {
        carrinho = new Carrinho();
        frame = new JFrame("Sistema de Vendas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        // Botões
        JButton addProdutoButton = new JButton("Adicionar Produto");
        JButton listarProdutosButton = new JButton("Listar Produtos");
        JButton calcularTotalButton = new JButton("Calcular Total");
        JButton realizarPagamentoButton = new JButton("Realizar Pagamento");

        // Adicionando botões ao frame
        frame.add(addProdutoButton);
        frame.add(listarProdutosButton);
        frame.add(calcularTotalButton);
        frame.add(realizarPagamentoButton);

        // Ações dos botões
        addProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        listarProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        calcularTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        realizarPagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPagamento();
            }
        });

        frame.setVisible(true);
    }

    private void adicionarProduto() {
        try {
            String marca = JOptionPane.showInputDialog(frame, "Digite a marca do produto:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o preço do produto:"));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite a quantidade:"));

            Produto produto = new Eletronico(marca, preco, quantidade); // Pode usar Roupa ou Eletronico
            carrinho.adicionarAoCarrinho(produto);

            JOptionPane.showMessageDialog(frame, "Produto adicionado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao adicionar produto: " + e.getMessage());
        }
    }

    private void listarProdutos() {
        StringBuilder produtosList = new StringBuilder("Produtos no carrinho:\n");
        for (Produto produto : carrinho.getProdutos()) {
            produtosList.append("- ").append(produto.getMarca()).append(" | Preço: R$ ")
                    .append(produto.getPreco()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, produtosList.toString());
    }

    private void calcularTotal() {
        double total = carrinho.calcularTotal();
        JOptionPane.showMessageDialog(frame, "Total da compra: R$ " + total);
    }

    private void realizarPagamento() {
        Pagamento pagamento = new Pagamento(carrinho, "Cartão de Débito");
        if (pagamento.processarPagamento()) {
            JOptionPane.showMessageDialog(frame, "Pagamento realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frame, "Falha no pagamento.");
        }
    }

    public static void main(String[] args) {
        new FrontJavaTest();
    }
}