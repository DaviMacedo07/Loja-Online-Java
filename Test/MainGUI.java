package Test;

import Classes.Carrinho;
import Classes.Eletronico;
import Classes.Pagamento;
import Classes.Roupa;
import abstractClass.Desconto;
import abstractClass.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame frame;
    private Carrinho carrinho;

    public MainGUI() {
        carrinho = new Carrinho();
        frame = new JFrame("Sistema de Vendas");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));


        JButton addProdutoButton = new JButton("Adicionar Produto");
        JButton listarProdutosButton = new JButton("Listar Produtos");
        JButton aplicarDescontoButton = new JButton("Aplicar Desconto");
        JButton calcularTotalButton = new JButton("Calcular Total");
        JButton cancelarItemButton = new JButton("Cancelar Item");
        JButton realizarPagamentoButton = new JButton("Realizar Pagamento");
        JButton exportarCSVButton = new JButton("Exportar para CSV");



        frame.add(addProdutoButton);
        frame.add(listarProdutosButton);
        frame.add(aplicarDescontoButton);
        frame.add(calcularTotalButton);
        frame.add(cancelarItemButton);
        frame.add(realizarPagamentoButton);
        frame.add(exportarCSVButton);



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


        aplicarDescontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarDesconto();
            }
        });


        calcularTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        cancelarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarItem();
            }
        });

        realizarPagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPagamento();
            }
        });



     exportarCSVButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exportarParaCSV();
        }
    });

   frame.setVisible(true);
}
    private void adicionarProduto() {
        try {
            String[] tipos = {"Roupa", "Eletronico"};
            int escolha = JOptionPane.showOptionDialog(
                    frame,
                    "Escolha o tipo de produto:",
                    "Adicionar Produto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tipos,
                    tipos[0]
            );

            String marca = JOptionPane.showInputDialog(frame, "Digite a marca do produto:");
            double preco = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o preço do produto:"));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Digite a quantidade:"));

            Produto produto;
            if (escolha == 0) { // Roupa
                char tamanho = JOptionPane.showInputDialog(frame, "Digite o tamanho (ex: M):").charAt(0);
                String cor = JOptionPane.showInputDialog(frame, "Digite a cor:");
                produto = new Roupa(marca, preco, quantidade, tamanho, cor);
            } else { // Eletronico
                produto = new Eletronico(marca, preco, quantidade);
            }

            carrinho.adicionarAoCarrinho(produto);
            JOptionPane.showMessageDialog(frame, "Produto adicionado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao adicionar produto: " + e.getMessage());
        }
    }


    private void listarProdutos() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "O carrinho está vazio.");
            return;
        }

        StringBuilder produtosList = new StringBuilder("Produtos no carrinho:\n");
        int index = 1;
        for (Produto produto : carrinho.getProdutos()) {
            produtosList.append(index).append(". ").append(produto.getMarca()).append(" | Preço: R$ ")
                    .append(produto.getPreco()).append("\n");
            index++;
        }

        JOptionPane.showMessageDialog(frame, produtosList.toString());
    }

    private void aplicarDesconto() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "O carrinho está vazio. Nada para aplicar desconto.");
            return;
        }

        StringBuilder produtosList = new StringBuilder("Selecione o número do produto para aplicar desconto:\n");
        int index = 1;
        for (Produto produto : carrinho.getProdutos()) {
            produtosList.append(index).append(". ").append(produto.getMarca())
                    .append(" | Preço: R$ ").append(produto.getPreco()).append("\n");
            index++;
        }

        String input = JOptionPane.showInputDialog(frame, produtosList.toString());
        try {
            int produtoIndex = Integer.parseInt(input) - 1;
            if (produtoIndex >= 0 && produtoIndex < carrinho.getProdutos().size()) {
                Produto produtoSelecionado = carrinho.getProdutos().get(produtoIndex);

                if (produtoSelecionado instanceof Desconto) {
                    double desconto = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o percentual de desconto:"));
                    double novoPreco = ((Desconto) produtoSelecionado).aplicarDesconto(desconto);
                    JOptionPane.showMessageDialog(frame, "Novo preço do produto: R$ " + novoPreco);
                } else {
                    JOptionPane.showMessageDialog(frame, "Este produto não suporta descontos.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Número inválido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao aplicar desconto: " + e.getMessage());
        }
    }

    private void calcularTotal() {
        double total = carrinho.calcularTotal();
        JOptionPane.showMessageDialog(frame, "Total da compra: R$ " + total);
    }

    private void cancelarItem() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "O carrinho está vazio. Nada para cancelar.");
            return;
        }

        StringBuilder produtosList = new StringBuilder("Selecione o número do produto para cancelar:\n");
        int index = 1;
        for (Produto produto : carrinho.getProdutos()) {
            produtosList.append(index).append(". ").append(produto.getMarca()).append(" | Preço: R$ ")
                    .append(produto.getPreco()).append("\n");
            index++;
        }

        String input = JOptionPane.showInputDialog(frame, produtosList.toString());
        try {
            int produtoIndex = Integer.parseInt(input) - 1;
            if (produtoIndex >= 0 && produtoIndex < carrinho.getProdutos().size()) {
                Produto produtoRemovido = carrinho.getProdutos().get(produtoIndex);
                carrinho.removerDoCarrinho(produtoRemovido);
                JOptionPane.showMessageDialog(frame, "Produto removido: " + produtoRemovido.getMarca());
            } else {
                JOptionPane.showMessageDialog(frame, "Número inválido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao cancelar produto: " + e.getMessage());
        }
    }

    private void realizarPagamento() {
        String[] opcoes = {"Cartão de Crédito", "Cartão de Débito"};
        int escolha = JOptionPane.showOptionDialog(
                frame,
                "Escolha o método de pagamento:",
                "Pagamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha == -1) {
            JOptionPane.showMessageDialog(frame, "Pagamento cancelado.");
            return;
        }

        String metodoPagamento = opcoes[escolha];
        Pagamento pagamento = new Pagamento(carrinho, metodoPagamento);
        if (pagamento.processarPagamento()) {
            JOptionPane.showMessageDialog(frame, "Pagamento realizado com sucesso! Método: " + metodoPagamento);
        } else {
            JOptionPane.showMessageDialog(frame, "Falha no pagamento.");
        }
    }

    private void exportarParaCSV() {
        String caminhoArquivo = JOptionPane.showInputDialog(frame, "Digite o caminho completo para salvar o arquivo (ex: C:\\carrinho.csv):");

        if (caminhoArquivo != null && !caminhoArquivo.trim().isEmpty()) {
            if (!caminhoArquivo.endsWith("\\")) {
                caminhoArquivo += "\\";
            }
            caminhoArquivo += "carrinho.csv";

            carrinho.exportarParaCSV(caminhoArquivo);
            JOptionPane.showMessageDialog(frame, "Arquivo CSV exportado com sucesso em: " + caminhoArquivo);
        } else {
            JOptionPane.showMessageDialog(frame, "Caminho do arquivo inválido.");
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}