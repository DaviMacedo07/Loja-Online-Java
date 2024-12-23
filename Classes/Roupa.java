package Classes;

import abstractClass.Desconto;
import abstractClass.Produto;

public class Roupa extends Produto implements Desconto {

    private char tamanho;
    private String cor;

    public Roupa(String marca, double preco, int quantidade, char tamanho, String cor) {
        super(marca, preco, quantidade);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
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
        System.out.println("Marca da Roupa: " + getMarca() +
                ",Preço: " + getPreco() +
                ", Tamanho: " + getTamanho() +
                ", Cor: " + getCor());
    }

    @Override
    public double aplicarDesconto(double porcentagem) {
        double desconto = getPreco() * (porcentagem / 100);
        setPreco(getPreco() - desconto);
        return getPreco();
    }
}
