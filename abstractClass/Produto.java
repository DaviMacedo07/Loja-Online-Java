package abstractClass;

public abstract class Produto {
    private String marca;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.marca = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    protected Produto() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + marca + ", Preço: " + preco + ", Quantidade: " + quantidade);
    }


}
