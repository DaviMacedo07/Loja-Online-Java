package Classes;

import abstractClass.Produto;

public class Roupa extends Produto {
    private String tamanho;
    private String cor;

    public Roupa(String nome, double preco, int estoque, String tamanho, String cor) {
        super(nome, preco, estoque);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Roupa: " + getNome() + ", Preço: " + getPreco() +
                ", Estoque: " + getEstoque() + ", Tamanho: " + tamanho +
                ", Cor: " + cor);
    }
}

