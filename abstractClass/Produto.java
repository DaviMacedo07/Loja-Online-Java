package abstractClass;

public abstract class Produto {
    private String nome;
    private double preco;
    private int quantidade; // novo atributo

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() { // novo getter
        return quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade);
    }
}
