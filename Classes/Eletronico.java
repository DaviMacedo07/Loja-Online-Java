package Classes;

import abstractClass.Produto;

public class Eletronico extends Produto {

    public double wt = 220;

    public Eletronico(String marca, double preco, int quantidade) {
        super(marca, preco, quantidade);
        this.wt = wt;
    }

    public double getWt() {
        return wt;
    }

    public void setWt(double wt) {
        this.wt = wt;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Marca do Eletronico: " + getMarca()
                + ", Preço: " + getPreco() +
                ", Quantidade: " + getQuantidade() +
                ", Voltagem: " + getWt() );
    }
}

