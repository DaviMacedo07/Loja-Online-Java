package Classes;

import abstractClass.Produto;

public class Eletronico extends Produto {
    private String marca;
    private int garantiaMeses;

    public Eletronico(String nome, double preco, int estoque, String marca, int garantiaMeses) {
        super(nome, preco, estoque);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Eletrônico: " + getNome() + ", Preço: " + getPreco() +
                ", Estoque: " + getEstoque() + ", Marca: " + marca +
                ", Garantia: " + garantiaMeses + " meses");
    }
}
